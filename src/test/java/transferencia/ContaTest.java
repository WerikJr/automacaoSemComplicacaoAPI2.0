package transferencia;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContaTest {

    Cliente xuxa;
    Cliente silvioSantos;
    Conta contaXuxa;
    Conta contaSilvio;

    @BeforeEach
    void setUp() {
        xuxa = new Cliente("Xuxa","73579114115","4910232");
        silvioSantos = new Cliente("Silvio Sangos","03149928125","492548");

        contaXuxa = new Conta("1590","10322",2500.00,xuxa);
        contaSilvio = new Conta("1080","197228",3500.00,silvioSantos);
    }

    @Test
    public void realizarTransacao(){

        contaXuxa.realizarTransferencia(1000.00,contaSilvio);

        assertEquals(1500.00,contaXuxa.getSaldo());
        assertEquals(4500.00,contaSilvio.getSaldo());
    }

    @Test
    public void validarTransferenciaInvalida(){

        boolean resultado = contaXuxa.realizarTransferencia(3500.00,contaSilvio);

        assertFalse(resultado);
    }

    @Test
    public void validarProprietario(){

        assertEquals(xuxa, contaXuxa.getProprietario());
    }

    @Test
    public void validarAgencia() {
        assertEquals("1590", contaXuxa.getAgencia());
    }

    @Test
    public void validarNumeroConta() {
        assertEquals("10322", contaXuxa.getNumeroConta());
    }

        @Test
       public void validarNome(){
            assertEquals("Xuxa", xuxa.getNome());
        }

    @Test
    public void validarCpf(){
        assertEquals("73579114115", xuxa.getCpf());
    }

    @Test
    public void validarRg(){
        assertEquals("4910232", xuxa.getRg());
    }

}