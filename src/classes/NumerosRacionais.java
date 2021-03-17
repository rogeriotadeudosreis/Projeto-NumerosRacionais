package classes;

public class NumerosRacionais {

    private int numerador = 0;
    private int denominador = 1;

    public NumerosRacionais() throws Exception {
        this.numerador = 0;
        if (denominador == 0) {
            throw new Exception("Denominador não pode ser == 0");
        } else {
            this.denominador = 1;
        }
    }

    public NumerosRacionais(int numerador, int denominador) throws Exception {
        this.numerador = numerador;
        this.denominador = denominador;

        if (denominador == 0) {
            throw new Exception("Denominador não pode ser == 0");
        }
    }

    public NumerosRacionais(NumerosRacionais objeto) {
        this.numerador = objeto.numerador;
        this.denominador = objeto.denominador;
    }

    public void set(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
    }

    public void set(NumerosRacionais objeto) {
        this.numerador = objeto.numerador;
        this.denominador = objeto.denominador;
    }

    public String get() {
        return (numerador + " / " + denominador);
    }

    private int calcularMDC(int den1, int den2) {

        int resto;
        int MDC = 0;
        while (den2 != 0) {
            resto = den1 % den2;
            den1 = den2;
            den2 = resto;
            MDC = den1;
        }
        return MDC;
    }

    private int calcularMMC(int den1, int den2) throws Exception {

        int MMC = (den1 * den2) / calcularMDC(den1, den2);

        return MMC;
    }

    public NumerosRacionais adicionar(NumerosRacionais objeto) throws Exception {
        /*
        Aqui criamos variáveis internas recebendo os valores dos 
        atributos e realizar os cálculos.        
         */
        int num1 = this.numerador;
        int den1 = this.denominador;
        int num2 = objeto.numerador;
        int den2 = objeto.denominador;
        int MMC;
        int somaNum;
        //Verificando se os denominadores são diferentes
        if (this.denominador != objeto.denominador) {
            //Caso os denominadores forem diferentes calcula-se o MMC
            MMC = calcularMMC(den1, den2);
            //Calculado o MMC, somamos os numeradores
            num1 = ((MMC / den1) * num1);
            num2 = ((MMC / den2) * num2);
            somaNum = num1 + num2;
            /*Aqui criamos um objeto para receber o resultado e jogamos 
            pra fora
            */             
            NumerosRacionais auxAdicao = new NumerosRacionais(somaNum, MMC);
            auxAdicao.reduzirNumRacional();
            return auxAdicao;
        } else {
            somaNum = ((this.numerador) + (objeto.numerador));
        NumerosRacionais auxAdicao = new NumerosRacionais(somaNum, den2);
        auxAdicao.reduzirNumRacional();
        return auxAdicao;            
        }
    }

    public NumerosRacionais subtrair(NumerosRacionais objeto) throws Exception {
        int Num1 = this.numerador;
        int Num2 = objeto.numerador;
        int den1 = this.denominador;
        int den2 = objeto.denominador;
        int MMC;
        int subNum;

        if (this.denominador != objeto.denominador) {

            MMC = calcularMMC(den1, den2);

            Num1 = ((MMC / den1) * Num1);
            Num2 = ((MMC / den2) * Num2);

            subNum = ((Num1) - (Num2));

            NumerosRacionais auxSubtracao = new NumerosRacionais(subNum, MMC);
            auxSubtracao.reduzirNumRacional();
            return auxSubtracao;

        } else {
            subNum = ((Num1) - (Num2));
            NumerosRacionais auxSubtracao =  new NumerosRacionais(subNum, den1);
            auxSubtracao.reduzirNumRacional();
            return auxSubtracao;
        }
    }

    public NumerosRacionais multiplicar(NumerosRacionais objeto) throws Exception {
        int numMult = ((this.numerador) * (objeto.numerador));
        int denMult = ((this.denominador) * (objeto.denominador));
        NumerosRacionais auxMultiplicacao = new NumerosRacionais(numMult, denMult);
        auxMultiplicacao.reduzirNumRacional();                
        return auxMultiplicacao;
    }

    public NumerosRacionais dividir(NumerosRacionais objeto) throws Exception {
        int numDiv = ((this.numerador) * (objeto.denominador));
        int denDiv = ((this.denominador) * (objeto.numerador));
        NumerosRacionais auxDivisao = new NumerosRacionais(numDiv, denDiv);
        auxDivisao.reduzirNumRacional();
        return auxDivisao;
    }

    public boolean compararIgualdade(NumerosRacionais objeto) throws Exception {

        int num = this.numerador;
        int den = this.denominador;
        int objNum = objeto.numerador;
        int objDen = objeto.denominador;
        reduzirNumRacional();

        return ((num == objNum) && (den == objDen));
    }

    private void reduzirNumRacional() throws Exception {

        int mdc = calcularMDC(numerador, denominador);

        numerador = numerador / mdc;
        denominador = denominador / mdc;
    }

}
