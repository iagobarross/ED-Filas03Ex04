/*4. Criar um projeto Java que implementa com a biblioteca Fila Genérica para simular um ambiente
corpora�vo, comum, como agências bancárias que tem diversos computadores e 1 impressora central.
Nesses casos, a impressora tem uma fila de impressões para que cada documento enviado comece e
termine a impressão sem que documentos se misturem.
A aplicação deve ter uma classe no package controller, ImpressoraController que tem os seguintes
métodos:

- insereDocumento(Fila f, String documento): void, o documento no formato
ID_PC;Nome_Arquivo (Já validado antes do envio) deverá enfileirar os documentos
enviados
- imprime(Fila f):void, que desenfilera um documento da fila, por vez, exibe no console
[#PC: ID_PC – Arquivo: Nome_Arquivo]. Cada impressão dura de 1 a 2 segundos usar
Math.random() ou a classe Random e um Thread.sleep*(tempo) para simular o tempo
de impressão. Exibir uma exceção caso não haja documento na fila de impressão.
Deve ter também uma classe Principal no package view com operações usando JOp�onPane que permita
ao usuário inserir e validar os documentos de entrada e iniciar um procedimento de impressão. A aplicação
deve rodar até uma opção de saída ser selecionada pelo usuário
* Como a classe de ImpressoraController não é uma Thread, para forçar um sleep, deve-se usar uma
chamada está�ca da classe Thread (Thread.sleep(tempo))
*/
package controller;

import br.edu.fateczl.Fila.*;

public class ImpressoraController {

	public ImpressoraController() {
		super();
	}
	
	public void insereDocumento(Fila<String> f, String documento) {
		f.insert(documento);
		
	}
	
	public void imprime(Fila<String> f) throws Exception {
		
		if(f.isEmpty()) {
			throw new Exception("Não há impressões na fila.");
		}
		
		while(!f.isEmpty()) {
			try {
				String documento = f.remove();
				String[] documentoSeparado = documento.split(";");
				System.out.println("#PC: " + documentoSeparado[0] + 
										" - Arquivo: " + documentoSeparado[1] + " imprimindo.");
				
				int tempo = (int)((Math.random() * 1001) + 1000);
				Thread.sleep(tempo);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
		}
		
	}

}
