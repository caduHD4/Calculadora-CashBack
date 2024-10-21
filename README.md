# **Relatório CAIXA PRETA :**

## Introdução

* ### Descrição da Atividade
    Este projeto tem como objetivo testar o cálculo de cashback baseado nas compras e no grau de fidelidade do cliente. Foram escritos testes unitários usando JUnit para garantir que a aplicação calcule corretamente o cashback conforme diferentes faixas de valor e graus de fidelidade.

* ### Objetivo dos Testes
    Os testes foram escritos para verificar se a aplicação calcula corretamente o cashback, respeitando as faixas de valor de compras e o grau de fidelidade do cliente (Bronze, Prata, e Ouro). Esses testes são para garantir a precisão dos cálculos e a robustez do sistema, especialmente ao lidar com valores nos limites das faixas.

* ### Conceito de Análise de Valor Limite
    A Análise de Valor Limite é uma técnica usada em testes de software para avaliar o comportamento do sistema nos limites das faixas de entrada. Ela é importante porque muitos erros ocorrem em pontos de transição, onde as regras de negócio mudam.

* ### Criterios do sistema
    O sistema deve registrar os valores das compras dos clientes, a porcentagem de cashback oferecida e o grau de fidelidade do cliente.

        O cálculo de cashback deve ser baseado em:

        • Valor Total das Compras: Total gasto pelo cliente em um período específico.

        • Percentual de Cashback Baseado em Faixas de Valor:

        ▪ Até R$ 100: Cashback de 5%.
        ▪ De R$ 100,01 até R$ 500: Cashback de 10%.
        ▪ Acima de R$ 500: Cashback de 15%.

        • Grau de Fidelidade do Cliente: Pode ser "Bronze", "Prata" ou "Ouro", com ajustes adicionais no cashback:

        ▪ Bronze: Nenhum ajuste.
        ▪ Prata: Aumento de 5% no percentual de cashback.
        ▪ Ouro: Aumento de 10% no percentual de cashback.

## Análise de Valor Limite

### Casos de Teste que Satisfazem a Análise do Valor Limite

* #### 1. Lista de Casos de Teste
    1. **Valor negativo (limite inferior abaixo de 0)**: Testa se o sistema retorna 0 para valores de compra negativos.
    2. **Valor muito próximo de 100**: Testa se o cashback muda corretamente entre as faixas de `5%` e `10%`.
    3. **Valor muito próximo de 500**: Verifica a transição entre `10%` e `15%`.
    4. **Valores altos (acima de R$ 1000)**: Garante que o cashback de 15% se aplique corretamente a grandes compras.

* #### 2. Entradas Utilizadas
    - Valores de compra (para cada grau): `-0,01, 0,01, 0,99, 99,99, 100,00, 100,01, 499,99, 500,00, 500,01, 1000,00, 5000,00, 10000,00`.
    - Graus de fidelidade: `"bronze", "prata", "ouro"`.

    *nota*: calculos adicionais de centavos.

* #### 3. Resultados Esperados
    - Para valores negativos, o cashback deve ser zero.
    - Para valores próximos a 100 e 500, o cashback deve ser de `5%`, `10%` ou `15%`, dependendo da faixa.
    - Para fidelidade `"prata" e "ouro"`, deve haver um aumento de `5%` ou `10%` no cashback.

### b. Aplicação do Critério nos Testes
- **Valores Limite Testados**: Foram utilizados valores como `-0,01, 0,01, 0,99, 100,00, 100,01, 499,99, 500,00, 500,01, 1000,00, 5000,00, 10000,00.`
- **Grau de Fidelidade**: Cada valor foi testado com os três graus de fidelidade (bronze, prata e ouro) para garantir que o sistema aplica corretamente os percentuais adicionais.

## 3. Execução dos Testes

* ### Processo de Execução
    Os testes foram executados no Visual Studio Code, usando a biblioteca JUnit.

* ### Resultados dos Testes
    Houveram diversas falhas. Por exemplo:
    - **Falha 1**: O teste de cashback para valores negativos em `"bronze"` esperava 0, mas o sistema retornou um valor "ligeiramente" negativo `(-5.0E-4)`.
    - **Falha 2**: O teste para o limite superior da partição D retornou um valor de cashback maior do que o esperado.

    *Nota*: As demais falhas seguem esse mesmo padrão.

* ### Logs dos Testes
    Aqui está um resumo dos resultado:
    - **Total de testes**: 32
    - **Sucessos**: 12
    - **Falhas**: 19
    - **Erros**: 1 (ocorreu pois resolvi testar oque aconteceria se executasse com um grau nulo)
    
    *Nota*: Fiz um ajuste para considerar somente até 4 casas decimais após o 0, pois alguns resultados de testes estavam resultando em um valor com uma casa decimal muito distante. Desta forma, agora ele pegará o valor relevante para o resultado. Mas, `caso não considerarmos essa alteração, dará 23 falhas e 1 erro.` Exemplo do caso: `AppTest.testaCashBackOuroLimiteInferiorParticaoC:126 expected:<15.0> but was:<15.000000000000002>`
    - **Testes com sucesso**:
      ```
        @Test
        public void testarCashBackBronzeValorElevado() {
            Double desconto = SimuladorCashback.calculaCashBack(1000.00, "bronze");
            Double esperado = 150.00;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackBronzeLimiteSuperior() {
            Double desconto = SimuladorCashback.calculaCashBack(0.01, "bronze");
            Double esperado = 0.0005;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackPrataLimiteSuperior() {
            Double desconto = SimuladorCashback.calculaCashBack(0.01, "prata");
            Double esperado = 0.001;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackOuroLimiteSuperior() {
            Double desconto = SimuladorCashback.calculaCashBack(0.01, "ouro");
            Double esperado = 0.0015;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackBronzeLimiteInferiorParticaoB() {
            Double desconto = SimuladorCashback.calculaCashBack(99.99, "bronze");
            Double esperado = 4.9995;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackPrataLimiteInferiorParticaoB() {
            Double desconto = SimuladorCashback.calculaCashBack(99.99, "prata");
            Double esperado = 9.999;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackOuroLimiteInferiorParticaoB() {
            Double desconto = SimuladorCashback.calculaCashBack(99.99, "ouro");
            Double esperado = 14.9985;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackBronzeLimiteInferiorParticaoC() {
            Double desconto = SimuladorCashback.calculaCashBack(100.00, "bronze");
            Double esperado = 5.0;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackPrataLimiteInferiorParticaoC() {
            Double desconto = SimuladorCashback.calculaCashBack(100.00, "prata");
            Double esperado = 10.0;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackOuroLimiteInferiorParticaoC() {
            Double desconto = SimuladorCashback.calculaCashBack(100.00, "ouro");
            Double esperado = 15.0;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackBronzeValorCentavos() {
            Double desconto = SimuladorCashback.calculaCashBack(0.99, "bronze");
            Double esperado = 0.0495;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testarCashBackPrataValorCentavos() {
            Double desconto = SimuladorCashback.calculaCashBack(0.99, "prata");
            Double esperado = 0.099;
            assertEquals(esperado, desconto, 0.0001);
        }

        @Test
        public void testaCashBackOuroValorCentavos() {
            Double desconto = SimuladorCashback.calculaCashBack(0.99, "ouro");
            Double esperado = 0.1485;
            assertEquals(esperado, desconto, 0.0001);
        }
      ```
    - **Testes com falhas**:
      ```
        Failures: 
        AppTest.testaCashBackPrataValorElevado:42 expected:<750.0> but was:<1000.0>
        AppTest.testarCashBackBronzeLimiteInferior:14 expected:<0.0> but was:<-5.0E-4>
        AppTest.testarCashBackBronzeLimiteInferiorParticaoD:162 expected:<24.9995> but was:<49.999>
        AppTest.testarCashBackBronzeLimiteSuperiorParticaoB:99 expected:<5.0005> but was:<10.001000000000001>
        AppTest.testarCashBackBronzeLimiteSuperiorParticaoC:141 expected:<5.001> but was:<10.002>
        AppTest.testarCashBackBronzeLimiteSuperiorParticaoD:183 expected:<25.0005> but was:<75.0015>
        AppTest.testarCashBackCategoriaInvalida Expected exception: java.lang.IllegalArgumentException
        AppTest.testarCashBackOuroLimiteInferior:28 expected:<0.0> but was:<-0.0015000000000000002>
        AppTest.testarCashBackOuroLimiteInferiorParticaoD:176 expected:<74.9985> but was:<99.998>
        AppTest.testarCashBackOuroLimiteSuperiorParticaoB:113 expected:<15.0015> but was:<20.002000000000002>
        AppTest.testarCashBackOuroLimiteSuperiorParticaoC:155 expected:<15.003> but was:<20.004>
        AppTest.testarCashBackOuroLimiteSuperiorParticaoD:197 expected:<75.0015> but was:<125.0025>
        AppTest.testarCashBackOuroValorElevado:50 expected:<1650.0> but was:<2500.0>
        AppTest.testarCashBackPrataLimiteInferior:21 expected:<0.0> but was:<-0.001>
        AppTest.testarCashBackPrataLimiteInferiorParticaoD:169 expected:<49.999> but was:<74.9985>
        AppTest.testarCashBackPrataLimiteSuperiorParticaoB:106 expected:<10.001> but was:<15.001500000000004>
        AppTest.testarCashBackPrataLimiteSuperiorParticaoC:148 expected:<10.002> but was:<15.003000000000002>
        AppTest.testarCashBackPrataLimiteSuperiorParticaoD:190 expected:<50.001> but was:<100.00200000000001>
        Errors: 
        AppTest.testarCashBackCategoriaNull �  Unexpected exception, expected<java.lang.IllegalArgumentException> but was<java.lang.NullPointerException>

        Tests run: 32, Failures: 18, Errors: 1, Skipped: 0
      ```

* ### Resultados da Análise de Valor Limite
    Os testes de valor limite apresentaram falhas em vários pontos, indicando que o sistema tem problemas na transição entre faixas de valor e no ajuste de cashback para valores muito baixos ou elevados.

* ### Alguns dos Problemas Encontrados
    AppTest.testaCashBackBronzeLimiteInferior:
    ```
    Esperado: 0.0
    Obtido: -5.0E-4 (ou -0.0005)
    
    Possível cálculo alterado: Parece que o desenvolvedor aplicou um cálculo de cashback negativo para valores abaixo de zero. 
    
    Isso sugere que o cálculo foi feito com algo como:
    valorCompra * percentualCashback = -0.01 * 0.05 = -0.0005
    
    Em vez de retornar 0 para valores negativos, ele aplicou o percentual de 5%.
    ```
    AppTest.testaCashBackBronzeLimiteInferiorParticaoD:
    ```
    Esperado: 24.9995
    Obtido: 49.999
    
    Possível cálculo alterado: Aqui parece que o cashback foi duplicado. O esperado seria:
    499.99 * 0.05 = 24.9995
    
    No entanto, o resultado sugere que o percentual aplicado foi 10% em vez de 5%:
    499.99 * 0.10 = 49.999
    
    Possivelmente, o desenvolvedor alterou a lógica para aplicar uma faixa de 10% indevidamente.
    ```
## Conclusão

* ### Descobertas
    Os testes revelaram que o sistema apresenta problemas nos cálculos de cashback em diversas situações de limite. Esses erros são causados por imprecisões numéricas ou lógica incorreta no ajuste de `%` do cashback para valores próximos aos limites de faixas.

* ### Robustez da Aplicação
    Com base nos resultados, a robustez da aplicação ainda precisa ser melhorada. As falhas nos valores limite e em entradas inválidas mostram que o sistema pode não lidar bem com todas as possíveis entradas, sendo necessário realizar ajustes no código e na lógica de cálculo do cashback.

