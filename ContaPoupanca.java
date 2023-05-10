public class ContaPoupanca extends Conta{

    public ContaPoupanca(int numero, Cliente titular) {
        super(numero, titular);
    }

    public void reajustar(double percentual) {
        this.saldo = this.saldo + this.saldo * percentual;
    }

    @Override
    public boolean sacar(double valor) {
        if (this.getSaldo() >= valor) {
            this.saldo -= valor;
            return true;
        } else {
            return false;
        }
    }
}