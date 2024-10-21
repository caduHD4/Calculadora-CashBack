package cashback;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import paranavai.ifpr.edu.br.simulador.SimuladorCashback;

public class AppTest {

    @Test
    public void testarCashBackBronzeLimiteInferior() {
        Double desconto = SimuladorCashback.calculaCashBack(-0.01, "bronze");
        Double esperado = 0.0;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackPrataLimiteInferior() {
        Double desconto = SimuladorCashback.calculaCashBack(-0.01, "prata");
        Double esperado = 0.0;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackOuroLimiteInferior() {
        Double desconto = SimuladorCashback.calculaCashBack(-0.01, "ouro");
        Double esperado = 0.0;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackBronzeValorElevado() {
        Double desconto = SimuladorCashback.calculaCashBack(1000.00, "bronze");
        Double esperado = 150.00;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testaCashBackPrataValorElevado() {
        Double desconto = SimuladorCashback.calculaCashBack(5000.00, "prata");
        Double esperado = 750.00;
        assertEquals(esperado, desconto, 0.0001);
    }


    @Test
    public void testarCashBackOuroValorElevado() {
        Double desconto = SimuladorCashback.calculaCashBack(10000.00, "ouro");
        Double esperado = 1650.00;
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
    public void testarCashBackBronzeLimiteSuperiorParticaoB() {
        Double desconto = SimuladorCashback.calculaCashBack(100.01, "bronze");
        Double esperado = 5.0005;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackPrataLimiteSuperiorParticaoB() {
        Double desconto = SimuladorCashback.calculaCashBack(100.01, "prata");
        Double esperado = 10.001;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackOuroLimiteSuperiorParticaoB() {
        Double desconto = SimuladorCashback.calculaCashBack(100.01, "ouro");
        Double esperado = 15.0015;
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
    public void testarCashBackBronzeLimiteSuperiorParticaoC() {
        Double desconto = SimuladorCashback.calculaCashBack(100.02, "bronze");
        Double esperado = 5.001;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackPrataLimiteSuperiorParticaoC() {
        Double desconto = SimuladorCashback.calculaCashBack(100.02, "prata");
        Double esperado = 10.002;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackOuroLimiteSuperiorParticaoC() {
        Double desconto = SimuladorCashback.calculaCashBack(100.02, "ouro");
        Double esperado = 15.003;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackBronzeLimiteInferiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(499.99, "bronze");
        Double esperado = 24.9995;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackPrataLimiteInferiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(499.99, "prata");
        Double esperado = 49.999;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackOuroLimiteInferiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(499.99, "ouro");
        Double esperado = 74.9985;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackBronzeLimiteSuperiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(500.01, "bronze");
        Double esperado = 25.0005;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackPrataLimiteSuperiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(500.01, "prata");
        Double esperado = 50.001;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test
    public void testarCashBackOuroLimiteSuperiorParticaoD() {
        Double desconto = SimuladorCashback.calculaCashBack(500.01, "ouro");
        Double esperado = 75.0015;
        assertEquals(esperado, desconto, 0.0001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testarCashBackCategoriaInvalida() {
        SimuladorCashback.calculaCashBack(100.00, "diamante");
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testarCashBackCategoriaNull() {
        SimuladorCashback.calculaCashBack(200.00, null);
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
}
