public class ContaBancaria {

    private double saldo;
    private int contagemConsultas;


public ContaBancaria(double saldoInicial) {   //construtor da conta bancaria 
    this.saldo = saldoInicial;
    this.contagemConsultas = 0;
}

public void depositar(double valor) {  // deposito com cobranca de taxa de 1%
    double taxa = valor * 0.01;

    this.saldo += valor - taxa;
    System.out.println("Deposito de R$" + valor + " realizado com taxa de R$" + taxa);

}

public void sacar(double valor) { // saque com cobranca de 0,5%
    double taxa = valor * 0.005;
    double valorTotal = valor + taxa;


if (valorTotal <= this.saldo) {   //verificando se o saldo e suficiente para realizar o saque 
    this.saldo -= valorTotal;   
    System.out.println("Saque de R$" + valor + " realizado com taxa de R$ " + taxa);
 
} else {
    System.out.println("Saldo insuficiente para saque de R$" + valor + ".");

 }
}

public double consultarSaldo() {  //metodo para consultar saldo cobrando uma taxa de 0,10 centavos a cada 5 consultas
    this.contagemConsultas++; 


    if (this.contagemConsultas % 5 == 0) {   // verifica se e a 5 consulta para aplicar a taxa 
        this.saldo -= 0.10;
        System.out.println("Taxa de R$0,10 cobrada por consulta ao saldo.");

    }


    return this.saldo;
}


public static void main(String[] args) {
    ContaBancaria conta = new ContaBancaria(1000.00); // Cria uma conta com saldo inicial
    conta.depositar(200.00); // Depósito
    conta.sacar(150.00); // Saque
    System.out.println("Saldo atual: R$" + conta.consultarSaldo()); // Consulta saldo
    conta.consultarSaldo(); // Consulta para ver a taxa

}
}