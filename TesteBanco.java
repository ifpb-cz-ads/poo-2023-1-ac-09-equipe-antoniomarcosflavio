import java.util.ArrayList;
import java.util.Scanner;

public class TesteBanco {
    public static void main(String[] args) {
        ArrayList<Conta> lista = new ArrayList<>();
        Conta conta = null;
        Scanner scan = new Scanner(System.in);
        int opcao, tipoConta, numeroConta;
        String nome, cpf;
        double valor;
        do {
            System.out.println("MENU");
            System.out.println("Escolha uma opção:");
            System.out.println("1 - Criar Conta");
            System.out.println("2 - Visualizar Saldo");
            System.out.println("3 - Sacar");
            System.out.println("4 - Depositar");
            System.out.println("0 - Sair do programa");
            opcao = scan.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("1 - Criar Conta Especial");
                    System.out.println("2 - Criar Conta Poupança");
                    tipoConta = scan.nextInt();
                    switch (tipoConta) {
                        case 1:
                            System.out.println("Digite o nome do titular: ");
                            nome = scan.nextLine();
                            System.out.println("Digite o cpf do titular: ");
                            cpf = scan.nextLine();
                            System.out.println("Informe o limite da conta:");
                            valor = scan.nextDouble();
                            System.out.println("Informe o número da conta:");
                            numeroConta = scan.nextInt();
                            conta = new ContaEspecial(numeroConta, new Cliente(nome, cpf), valor);
                            break;
                        case 2:
                            System.out.println("Digite o nome do titular: ");
                            nome = scan.nextLine();
                            System.out.println("Digite o cpf do titular: ");
                            cpf = scan.nextLine();
                            System.out.println("Informe o número da conta:");
                            numeroConta = scan.nextInt();
                            conta = new ContaPoupanca(numeroConta, new Cliente(nome, cpf));
                            break;
                        default:
                            System.out.println("A opçao de conta escolhida não é válida");
                            break;
                    }
                    lista.add(conta);
                    break;
                case 2:
                    System.out.println("Informe o número da conta");
                    numeroConta = scan.nextInt();
                    for (int k = 0; k < lista.size(); k++) {
                        Conta n = lista.get(k);
                        if (n.numero == numeroConta) {
                            System.out.println("O saldo da conta é: " + n.getSaldo());
                            break;
                        }
                        if (k + 1 == lista.size()) {
                            System.out.println("A conta é inexistente");
                            break;
                        }
                    }
                    break;
                case 3:
                    System.out.println("Informe o número da conta");
                    numeroConta = scan.nextInt();
                    for (int k = 0; k < lista.size(); k++) {
                        Conta n = lista.get(k);
                        if (n.numero == numeroConta) {
                            System.out.println("Informe o valor do saque");
                            valor = scan.nextDouble();
                            n.sacar(valor);
                            System.out.println("Você sacou: " + valor);
                            System.out.println("O saldo da conta é: " + n.getSaldo());
                            break;
                        }
                        if (k + 1 == lista.size()) {
                            System.out.println("A conta é inexistente");
                            break;
                        }
                    }
                    break;
                case 4:
                    System.out.println("Informe o número da conta");
                    numeroConta = scan.nextInt();
                    for (int k = 0; k < lista.size(); k++) {
                        Conta n = lista.get(k);
                        if (n.numero == numeroConta) {
                            System.out.println("Informe o valor do deposito");
                            valor = scan.nextDouble();
                            n.depositar(valor);
                            System.out.println("Você depositou: " + valor);
                            System.out.println("O saldo da conta é: " + n.getSaldo());
                            break;
                        }
                        if (k + 1 == lista.size()) {
                            System.out.println("A conta é inexistente");
                            break;
                        }
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("A opção escolhida é inválida");
                    break;
            }
        } while (opcao != 0);
        scan.close();
    }
}