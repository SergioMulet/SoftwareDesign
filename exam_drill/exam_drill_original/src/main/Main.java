package main;

import java.io.*;
import java.util.Arrays;
import java.util.regex.*;

public class Main {
	
	public static void main(String[] args) {

		StringBuilder text = new StringBuilder("");

		drawLogo();
		showHelp();

		do {
			System.out.print("> ");

			String userInput = askUser();

			if (userInput.equals("salir")) {
				System.out.println("¡Adiós!");
				return;
			}

			if (userInput.isBlank()) {
				continue;
			}

			String[] parts = userInput.split(" ");
			String option = parts[0];
			String[] params = Arrays.copyOfRange(parts, 1, parts.length);

			// No se comprueba que el número de parámetros sea correcto

			if (option.equals("abrir")) {
				try {
					String filename = params[0];
					text = new StringBuilder(readFile(filename));
				} catch (IOException e) {
					System.out.println("No se pudo leer el fichero");
				}
			} else if (option.equals("insertar")) {
				for (String word : params) {
					text.append(word + " ");
				}
			} else if (option.equals("borrar")) {
				int indexOfLastWord = text.toString().trim().lastIndexOf(" ");
				if (indexOfLastWord == -1)
					text = new StringBuilder("");
				else
					text.setLength(indexOfLastWord + 1);
			} else if (option.equals("reemplazar")) {
				String find = params[0];
				String replace = params[1];
				text = new StringBuilder(text.toString().replaceAll(Pattern.quote(find), replace));
			} else if (option.equals("grabar")) {
				// To be done
			} else if (option.equals("parar")) {
				// To be done
			} else if (option.equals("ejecutar")) {
				// To be done
			} else if (option.equals("ayuda")) {
				showHelp();
			} else {
				System.out.println("Opción incorrecta");
			}

			System.out.println(text);
			
		} while (true);
	}

	private static String readFile(String filename) throws IOException {
		BufferedReader input = new BufferedReader(new FileReader(filename));
		String line;
		StringBuilder result = new StringBuilder();
		while ((line = input.readLine()) != null) {
			result.append(line);
		}
		input.close();
		return result.toString();
	}

	private static String askUser() {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line = "";
		try {
			line = in.readLine();
		} catch (IOException e) {
			System.out.println("Error al leer la entrada del usuario");
			System.exit(1);
		}
		return line.trim();
	}

	private static void drawLogo() {
		System.out.println(LOGO);
	}

	private static void showHelp() {
		System.out.println(HELP);
	}

	private static final String LOGO = """
			███╗   ███╗ █████╗  ██████╗████████╗███████╗██╗  ██╗
			████╗ ████║██╔══██╗██╔════╝╚══██╔══╝██╔════╝╚██╗██╔╝
			██╔████╔██║███████║██║        ██║   █████╗   ╚███╔╝ 
			██║╚██╔╝██║██╔══██║██║        ██║   ██╔══╝   ██╔██╗ 
			██║ ╚═╝ ██║██║  ██║╚██████╗   ██║   ███████╗██╔╝ ██╗
			╚═╝     ╚═╝╚═╝  ╚═╝ ╚═════╝   ╚═╝   ╚══════╝╚═╝  ╚═╝
			""";

	private static final String HELP = """
			┌──────────────────────┬───────────────────────────────────────────┐
			│ abrir <fichero>      │                                           │
			│ insertar <texto>     │ añade el texto al final                   │
			│ borrar               │ borra la última palabra                   │
			│ reemplazar <a> <b>   │ cambia <a> por <b> en todo el texto       │
			├──────────────────────┼───────────────────────────────────────────┤
			│ grabar <macro>       │ comienza la grabación de una macro        │
			│ parar                │ finaliza la grabación                     │
			│ ejecutar <macro>     │ ejecuta la macro cuyo nombre se indique   │
			├──────────────────────┼───────────────────────────────────────────┤
			│ ayuda                │                                           │
			│ salir                │                                           │
			└──────────────────────┴───────────────────────────────────────────┘
			""";
}