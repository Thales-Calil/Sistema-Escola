package br.com.sistemaescolar.app;
import jakarta.persistence.Persistence;
import jakarta.persistence.EntityManagerFactory;

public class MainApp {
    public static void main(String[] args) {
        System.out.println("=== Teste do Sistema Escolar ===");

        try {
            EntityManagerFactory emf = Persistence.createEntityManagerFactory("sistemaescolarPU");
            System.out.println("✅ Conexão com o banco configurada com sucesso!");
            emf.close();
        } catch (Exception e) {
            System.out.println("❌ Erro ao criar EntityManagerFactory:");
            e.printStackTrace();
            return; // Interrompe o programa se falhar
        }

        // (o resto do seu código vem aqui abaixo)
    }
}