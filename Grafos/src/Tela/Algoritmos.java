package Tela;

import java.util.ArrayList;

import Metodos.Aresta;
import Metodos.Grafo;
import Metodos.Keyboard;
import Metodos.Vertice;



public class Algoritmos {
	
	public static void main(String arg[]) {

		Grafo inicial = new Grafo();
		Grafo resultado = new Grafo();
		
		Aresta arestaAux;
		Vertice verticeAux1, verticeAux2;
		int opcao = 5, peso;
		String origem , destino;
		
		while(opcao!=0){
			System.out.println("1 - Add vertices e aresta");
			System.out.println("2 - Imprimir Grafo dado");
			System.out.println("3 - Obter Ordenacao Topologica");
			System.out.println("4 - Obter caminho de Dijkstra");
			System.out.println("5 - Obter arvore de Busca em Profundidade");
			System.out.println("0 - fim");
			
			opcao = Keyboard.readInt();
			
			//dando um reset no grafo de resultado
			resultado.clearLists();
			
			//limpando verificadores booleanos
			inicial.limparArestaVisitada();
			inicial.limparVerticeVisitado();
			
			switch (opcao){
			case 1:
				
				System.out.println("Digite o peso da aresta");
				peso = Keyboard.readInt();
				System.out.println("Digite o ponto de origem");
				origem = Keyboard.readString();
				System.out.println("Digite o ponto de destino");
				destino = Keyboard.readString();
				inicial.addAresta(peso,origem,destino);
				
				inicial.imprimeArvore();
				break;
			case 2:
				inicial.imprimeArvore();
				break;
			case 3: 
				//Ordenacao Topologica
				
				ArrayList<Vertice> vertices = inicial.topologicalSort();
				int count = 1;
				for (Vertice vertice: vertices) {
					System.out.println(count + " " + vertice.getNome());
					count++;
				}
				break;
			case 4:
				//Algoritmo de Dijkstra
				
				verticeAux1 = inicial.acharVertice(Keyboard.readString());
				verticeAux2 = inicial.acharVertice(Keyboard.readString());
				resultado.setVertices(inicial.encontrarMenorCaminhoDijkstra(verticeAux1, verticeAux2));
				
				System.out.println(resultado.getVertices());
				break;
				
			case 5:
				//Algoritmo de Busca em Profundidade
			
				origem = Keyboard.readString();
				destino = Keyboard.readString();
				resultado.setArestas(inicial.buscaEmProfundidade(origem, destino));
				
				resultado.imprimeArvore();
				break;


			case 0:
				break;
			default:
				System.out.println("invalido");
				break;
			}
			
		}
	}
}