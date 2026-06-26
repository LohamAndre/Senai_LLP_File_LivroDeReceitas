import java.io.*;
import java.util.*;

public class LivroDeReceitas {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);

        System.out.print("Receita: ");
        String nome = sc.nextLine();

        List<String> ingredientes = new ArrayList<>();
        System.out.println("\nIngredientes (deixe em branco para parar):");
        for (int i = 1; ; i++) {
            System.out.print("  " + i + ". Descricao: ");
            String desc = sc.nextLine();
            if (desc.isBlank()) break;
            System.out.print("  " + i + ". Quantidade: ");
            ingredientes.add(i + ". " + desc + " - " + sc.nextLine());
        }

        List<String> passos = new ArrayList<>();
        System.out.println("\nPassos (deixe em branco para parar):");
        for (int i = 1; ; i++) {
            System.out.print("  Passo " + i + ": ");
            String passo = sc.nextLine();
            if (passo.isBlank()) break;
            passos.add("Passo " + i + ": " + passo);
        }

        String arquivo = nome.trim().replaceAll("\\s+", "_") + ".txt";
        PrintStream out;
        try { out = new PrintStream(arquivo); }
        catch (Exception e) { out = System.out; }

        out.println(nome);
        out.println();
        ingredientes.forEach(out::println);
        out.println();
        passos.forEach(out::println);

        System.out.println("\nReceita salva em: " + arquivo + " :)");
    }
}