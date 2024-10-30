package Robinzon_Promedi;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Promedio {
    
    public static void main(String [] args) throws IOException{
        Promedio promedio = new Promedio();
        
        promedio.Menu();
    }
    
    Scanner input = new Scanner(System.in);
    float nota1 = 0, nota2 = 0, nota3 = 0, promedio = 0;
    int opcMenu = 0;
    
    public void ingresarNotas(){
        System.out.print("Ingrese calificacion 1: ");
        nota1 = input.nextFloat();
        while(nota1 < 0 || nota1 > 20){
            System.out.print("\t Calificacion incorrecta, por favor ingrese correctamente: ");
            nota1 = input.nextFloat();
        }
        
        System.out.print("Ingrese calificacion 2: ");
        nota2 = input.nextFloat();
        while(nota2 < 0 || nota2 > 20){
            System.out.print("\t Calificacion incorrecta, por favor ingrese correctamente: ");
            nota2 = input.nextFloat();
        }
        
        System.out.print("Ingrese calificacion 3: 1");
        nota3 = input.nextFloat();
        while(nota3 < 0 || nota3 > 20){
            System.out.print("\t Calificacion incorrecta, por favor ingrese correctamente: ");
            nota3 = input.nextFloat();
        }
        
        System.out.println("Su promedio es: "+Promedio());
        
        if (Promedio() >= 14){
            System.out.println("Aprobado. ");
        } else if (Promedio() < 14){
            System.out.println("Reprobado");
        }
        
    }
    
    public float Promedio(){
        promedio = (nota1+nota2+nota3)/3;
        return promedio;
    }
    
    public String toCsv(){
        return "Calificacion 1: "+nota1+"\n"+
                "calificacion 2: "+nota2+"\n"+
                "Calificacion 3: "+nota3+"\n"+
                "Promedio: "+Promedio()+"\n";
    }
    public void generarCsv() {
        try(BufferedWriter CSV = new BufferedWriter(new FileWriter("Archivo.csv"))){
            CSV.append(toCsv());
            System.out.println("Archivo CSV creado correctamente. ");
        } catch(IOException e){
            System.out.println("Error al crear el archivo CSV...");
        }
    }
    
    public void generarJson(){
        
        String json = "{\n" +
                      "  \"calificacion1\": " + nota1 + ",\n" +
                      "  \"calificacion2\": " + nota2 + ",\n" +
                      "  \"calificacion3\": " + nota3 + ",\n" +
                      "  \"promedio\": " + Promedio() + "\n" +
                      "}";
        
        try(BufferedWriter JSON = new BufferedWriter(new FileWriter("Archivo.Json"))){
            JSON.write(json);
            System.out.println("Archivo JSON creado correctamente.");
        }catch(IOException e){
             System.out.println("Error al crear el archivo JSON...");
        }
    }
    
    public void Menu() throws IOException{
        do{
            System.out.println("MENU");
            System.out.println("1. Ingreso de notas");
            System.out.println("2. Generar scv");
            System.out.println("3.  Generar Json");
            System.out.println("4. Salir");
            opcMenu = input.nextInt();
            switch(opcMenu){
                case 1: {
                    ingresarNotas();
                    break;
                }
                case 2: {
                    generarCsv();
                    break;
                }
                case 3: {
                    generarJson();
                    break;
                }
                case 4: {
                    System.out.println("Saliendo...");
                    break;
                }
            }
        }while(opcMenu != 4);
    }
    
    
    
    
}


