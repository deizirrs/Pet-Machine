package deizianeRodrigues.exercicio.petMachine;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	private static final Scanner sc = new Scanner(System.in);

	private final static PetMachine petMachine = new PetMachine();

	public static void main(String[] args) {

		int option = -1;
		do {
			System.out.println("**************Serviços*****************");
			System.out.println("1 - Dar banho no pet");
			System.out.println("2 - Abastecer a máquina com água");
			System.out.println("3 - Abastecer a máquina com shampoo");
			System.out.println("4 - Verificar água da máquina");
			System.out.println("5 - Verificar shampoo da máquina");
			System.out.println("6 - Verificar se tem pet no banho");
			System.out.println("7 - Colocar pet da máquina");
			System.out.println("8 - Retirar pet da máquina");
			System.out.println("9 - Limpar a máquina");
			System.out.println("0 - Sair");
			System.out.println("**************************************");
			System.out.println();

			System.out.println("Informe o serviço desajado: ");

			try {
				option = sc.nextInt();
				sc.nextLine(); 

			} catch (InputMismatchException e) {
				System.out.println("Entrada inválida! Por favor, informe uma opção de serviço entre 0 e 9.\n");
				sc.nextLine();
				continue;
			}

			if (option < 0 || option > 9) {
				System.out.println("Opção de serviço inválida.\n");
				continue;
			}

			switch (option) {
			case 1:
				petMachine.takeAShower();
				break;
			case 2:
				setWater();
				break;
			case 3:
				setShampoo();
				break;
			case 4:
				verifyWater();
				break;
			case 5:
				verifyShampoo();
				break;
			case 6:
				CheckIFhasPetInMachine();
				break;
			case 7:
				setPetMachine();
				break;
			case 8:
				petMachine.removePet();
				break;
			case 9:
				petMachine.wash();
				break;
			case 0:
				System.exit(0);
				break;
			}

		} while (option != 0);
	}

	public static void setWater() {
		System.out.println("Colocando água na máquina...");
		petMachine.addWater();
	}

	public static void setShampoo() {
		System.out.println("Colocando shampoo na máquina...");
		petMachine.addShampoo();
	}

	public static void verifyWater() {
		var amout = petMachine.getWater();
		System.out.println("Volume atual de água na máquina: " + amout + " litro(s).");
	}

	public static void verifyShampoo() {
		var amout = petMachine.getShampoo();
		System.out.println("Volume atual de Shampoo na máquina: " + amout + " litro(s).");
	}

	public static void CheckIFhasPetInMachine() {

		var hasPet = petMachine.hasPet();
		System.out.println(hasPet ? "Tem pet na máquina." : "Não tem pet na máquina.");
	}

	public static void setPetMachine() {
		String name = "";
		while (name == null || name.isEmpty()) {
			System.out.println("Informe o nome do pet: ");
			name = sc.nextLine();
		}

		var pet = new Pet(name);
		petMachine.setPet(pet);
	}
}
