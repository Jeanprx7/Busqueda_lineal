/*
Integrantes:
-David Uyuaguari
-Roberto Zamora
-Santiago Pilamunga
-Jean Paul Rodriguez

Metodo de Busqueda : BUSQUEDA LINEAL
 */

import javax.swing.*;
import java.util.jar.JarEntry;

public class Lista {

    public Nodo inicio;
    public int tamano;

    public Lista() {
        inicio = null;
        tamano = 0;

    }

    public int buscarLineal(int dato){
        Nodo actual = inicio;
        int posicion = 0;

        while(actual!=null){
            if(actual.dato == dato){
                return posicion;
            }
            actual = actual.siguiente;
            posicion++;
        }
        return -1;
    }
    public void agregar(int dato, JTextArea textArea){
        Nodo nuevoNodo = new Nodo(dato);

        if(inicio==null){
            inicio = nuevoNodo;

        }else{
            Nodo actual = inicio;

            while(actual.siguiente != null){
                actual = actual.siguiente;
            }
            actual.siguiente = nuevoNodo;
        }
        tamano++;
        actualizarLista(textArea);

    }

    public boolean eliminar(int dato,JTextArea textArea) {
        if (inicio == null) {
            JOptionPane.showMessageDialog(null, "Lista vacia");
            return false;

        }
        if (inicio.dato == dato) {
            inicio = inicio.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }

        Nodo actual = inicio;
        while (actual.siguiente != null && actual.siguiente.dato != dato) {
            actual = actual.siguiente;
        }

        if (actual.siguiente != null) {
            actual.siguiente = actual.siguiente.siguiente;
            tamano--;
            actualizarLista(textArea);
            return true;
        }
        JOptionPane.showMessageDialog(null, "Elemento no encontrado");
        return false;



    }
    public void mostrarLista(JTextArea textArea){
        if(inicio==null){
            textArea.setText("Lista vacia");
        }else{
            StringBuilder listaStr = new StringBuilder();
            Nodo actual = inicio;

            while(actual != null){
                listaStr.append(actual.dato)
                        .append("\n");
                actual =actual.siguiente;
            }
            textArea.setText(listaStr.toString());
        }
    }
    public void actualizarLista(JTextArea textArea){
        mostrarLista(textArea);
    }
}
