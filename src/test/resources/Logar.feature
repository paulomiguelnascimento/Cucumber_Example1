#language: pt

Funcionalidade: Login
	
	Cenario: Login com Sucesso
				Dado que cliente acessa o site da automacao pratica
				Quando clico em entrar
				Entao efetuo login corretamente
				
	Cenario: Login Invalido
				Dado que cliente acessa o site da automacao pratica
				Quando aciono o botao entrar informando um usuario invalido
				Entao valido mensagem de erro
				
	Cenario: Senha Invalida
				Dado que cliente acessa o site da automacao pratica
				Quando aciono o botao entrar informando uma senha invalida
				Entao valido mensagem de senha incorreta
				
	Cenario: Autenticacao Falhou
				Dado que cliente acessa o site da automacao pratica
				Quando aciono o botao entrar informando uma senha incorreta
				Entao valido mensagem de autenticacao falhou		
				
		
				
