public abstract class Conta {
    protected int numero;
    protected Cliente titular;
    protected double saldo;

    public Conta(int numero, Cliente titular, double saldo) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
    }

    public Conta(int numero, Cliente titular) {
        this.numero = numero;
        this.titular = titular;
        saldo = 0;
    }
    public Conta(int numero, String nometitular, String cpftitular) {
        this.numero = numero;
        this.titular = new Cliente(nometitular, cpftitular);
        saldo = 0;
    }

    public void depositar(double valor) {
        this.saldo = this.getSaldo() + valor;
    }

    public abstract boolean sacar(double valor);

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void setNome_titular(Cliente titular) {
        this.titular = titular;
    }
}