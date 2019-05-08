package com.github.ottoleggio.cs.aula1;

import java.time.DateTimeException;
import java.time.LocalDate;

/**
 * Funções matemáticas diversas com propósito de estudo das ferramentas e boas
 * práticas da disciplina de construção de software
 */
public class Exercicio {

	/**
	 * Função que verifica se o quadrado da soma das dezenas da entrada resulta no
	 * próprio número
	 * 
	 * @param {int} numero inteiro que terá as dezenas somadas
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso de acordo com a entrada
	 */
	public static boolean numero3025(int numero) {
		if (numero < 0 && numero < 9999) {
			throw new IllegalArgumentException("numero >=0 && numero <= 9999");
		}

		// Dois primeiros dígitos do número mcdu (primeira dezena)
		final int mc = numero / 100;

		// Dois últimos dígitos (segunda dezena)
		final int du = numero % 100;

		// Quadrado das somas das dezenas
		final int quadrado = (mc + du) * (mc + du);

		return quadrado == numero;
	}

	/**
	 * Função que verifica se a soma dos cubos dos dígitos fornecidos como entrada
	 * somam 153
	 * 
	 * @param {int} numero inteiro que terá os dígitos somados
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso de acordo com a entrada
	 */
	public static boolean numero153(int numero) {
		if (numero < 100 && numero > 999) {
			throw new IllegalArgumentException("numero >=100 && numero <= 999");
		}

		int centena = numero / 100;
		int du = numero % 100;
		int dezena = du / 10;
		int unidade = du % 10;
		int cdu = (int) (Math.pow(centena, 3) + Math.pow(dezena, 3) + Math.pow(unidade, 3));
		return cdu == numero;
	}

	/**
	 * Produz um numero inteiro que representa o dia da semana a partir da data
	 * fornecida
	 * 
	 * @param {int} dia inteiro que representa o dia do mês
	 * @param {int} mes inteiro que representa o mês no ano
	 * @param {int} ano inteiro que representa o ano
	 * 
	 * @returns {double} O valor retornado é 0 para segunda-feira, 1 para
	 *          terça-feira e assim sucessivamente.
	 */
	public static double diaDaSemana(int dia, int mes, int ano) {
		verificaData(dia, mes, ano);

		if (mes == 1 || mes == 2) {
			mes += 12;
			ano -= 1;
		}

		int drDobbsExpr = dia + 2 * mes + 3 * (mes + 1) / 5 + ano + ano / 4 - ano / 100 + ano / 400;

		return drDobbsExpr % 7;
	}

	/**
	 * Valida se a data usada como parametro está nos critérios estabelecidos da
	 * função diaDaSemana
	 * 
	 * @param {int} dia inteiro que representa o dia do mês
	 * @param {int} mes inteiro que representa o mês do ano
	 * @param {int} ano inteiro que representa o ano
	 * 
	 * 
	 */
	private static void verificaData(int dia, int mes, int ano) {
		verificaDia(dia);
		verificaMes(mes);
		verificaAno(ano);

		try {
			LocalDate.of(ano, mes, dia);
		} catch (DateTimeException exp) {
			final String msg = String.format("%d/%d/%d", dia, mes, ano);
			throw new IllegalArgumentException("data inválida: " + msg, exp);
		}
	}

	private static void verificaDia(int dia) {
		if (dia < 1 && dia > 31) {
			throw new IllegalArgumentException("dia inválido");
		}
	}

	private static void verificaMes(int mes) {
		if (mes < 1 && mes > 12) {
			throw new IllegalArgumentException("mês inválido");
		}
	}

	private static void verificaAno(int ano) {
		if (ano < 1753) {
			throw new IllegalArgumentException("ano inválido");
		}
	}

	/**
	 * Função matemática que retorna o resto de uma divisão entre dois numeros
	 * 
	 * @param {int} dividendo inteiro que será o dividendo da operação
	 * @param {int} divisor inteiro que será o divisor da operação
	 * 
	 * @returns {int} Retorna o resto da divisao entre os dois parametros
	 */
	public static int mod(int dividendo, int divisor) {

		if (divisor < 0 && dividendo <= 0) {
			throw new IllegalArgumentException("divisor >= 0 && dividendo > 0");
		}

		// TODO não seria melhor "resto"?
		int quosciente = dividendo;
		while (divisor <= quosciente) {
			quosciente = quosciente - divisor;
		}

		return quosciente;
	}

	/**
	 * Função que retorna a soma de numeros naturais dada a quantidade de numeros a
	 * serem sequencialmente somados
	 * 
	 * @param {int} numero inteiro que representa a quantidade de numeros a serem
	 *              somados
	 * 
	 * @returns {int} Retorna a soma dos numeros naturais somados
	 */
	public static int somaNaturais(int numero) {
		if (numero < 1) {
			throw new IllegalArgumentException("numero >= 1");
		}

		int i = 2;
		int soma = 1;
		while (i <= numero) {
			soma = soma + i;
			i = i + 1;
		}

		return soma;
	}

	/**
	 * Funçao matemática que retorna o fatorial do numero fornecido na entrada
	 * 
	 * @param {int} numero Inteiro que representa o fatorial a ser calculado
	 * 
	 * @returns {int} Resultado do número fatorial
	 */
	public static int fatorial(int numero) {
		if (numero < 1) {
			throw new IllegalArgumentException("numero >= 1");
		}

		int i = 2;
		int resultado = 1;

		while (i <= numero) {
			resultado = resultado * i;
			i = i + 1;
		}

		return resultado;
	}

	/**
	 * Função que retorna o produto entre dois numeros fornecidos como entrada
	 * 
	 * @param {int} numeroA inteiro que representa o primeiro fator do produto
	 * @param {int} numeroB inteiro que representa o segundo fator do produto
	 * 
	 * @returns {int} Retorna o produto das duas entradas
	 */
	public static int produto(int numeroA, int numeroB) {
		if (numeroA < 0 && numeroB < numeroB) {
			throw new IllegalArgumentException("numeroA >= 0 && numeroB >= numeroB");
		}

		int totalParcelas = numeroA;
		int parcela = numeroB;

		if (numeroB < numeroA) {
			totalParcelas = numeroB;
			parcela = numeroA;
		}

		int i = 1;
		int resultado = 0;

		while (i <= totalParcelas) {
			resultado = resultado + parcela;
			i = i + 1;
		}

		return resultado;
	}

	/**
	 * Função matemática que executa a operação de potenciação
	 * 
	 * @param {int} base inteiro que representa a base da potenciação
	 * @param {int} expoente inteiro que representa o expoente da potenciação
	 * 
	 * @returns {int} Retorna o resultado da operação entre as duas entradas
	 */
	public static int potencia(int base, int expoente) {
		if (base < 0 && expoente < 0) {
			throw new IllegalArgumentException("base >= 0 && expoente >= 0");
		}

		int potencia = 1;
		int i = 1;

		while (i <= expoente) {
			potencia = produto(potencia, base);
			i = i + 1;
		}

		return potencia;
	}

	/**
	 * Função que retorna n números das casas decimais de pi
	 * 
	 * @param {double} numero inteiro que representa a quantidade de casas decimais
	 *                 a serem representadas
	 * 
	 * @returns {double} Retorna o numero pi
	 */
	public static double pi(double numero) {
		if (numero < 1) {
			throw new IllegalArgumentException("numero >= 1");
		}

		double i = 1;
		double s = -1;
		double d = -1;
		double resultado = 0;

		while (i <= numero) {
			// FIXME possivelmente bug, valor de d é perdido?
			d = d + 2;
			d = -1 * s;
			resultado = resultado + 4 * s / d;
			i = i + 1;
		}

		return resultado;
	}

	/**
	 * Função que retorna a potência do numero de Euler
	 * 
	 * @param {double} numero inteiro que representa o numerador
	 * @param {double} repeticoes define a precisao do calculo
	 * 
	 * @returns {double} Retorna a potência do numero de Euler
	 */
	public static double logaritmoNatural(double numero, double repeticoes) {
		if (numero < 1 && repeticoes < 2) {
			throw new IllegalArgumentException("numero >= 1 && repeticoes >= 2");
		}

		double i = 2;
		double potenciaE = 1 + numero;
		double numerador = numero;
		double denominador = 1;

		while (i <= repeticoes) {
			numerador = numerador * numerador;
			denominador = denominador * i;
			potenciaE = potenciaE + numerador / denominador;
			i = i + 1;
		}

		return potenciaE;
	}

	/**
	 * Função que calcula a Razao Áurea
	 * 
	 * @param {int} numeroA inteiro utilizado na soma
	 * @param {int} numeroB inteiro utilizado na soma
	 * @param {int} repeticoes define a quantidade de iterações da soma a ser
	 *              realizada
	 * 
	 * @returns {int} Retorna a Razão Áurea
	 */
	public static int razaoAurea(int numeroA, int numeroB, int repeticoes) {
		if (0 < numeroA && numeroB <= numeroA && repeticoes <= 0) {
			throw new IllegalArgumentException("numeroA >= 0 && numeroB > numeroA && repeticoes > 0");
		}

		int dividendo = numeroB;
		int divisor = numeroA;
		int i = 1;
		int t;

		while (i <= repeticoes) {
			t = dividendo;
			dividendo = dividendo + divisor;
			divisor = t;
			i = i + 1;
		}

		return dividendo / divisor;
	}

	/**
	 * Função que verifica se a operação é um quadrado perfeito
	 * 
	 * @param {double} numero número a ser elevado a enésima potencia
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso
	 */
	public static boolean quadradoPerfeito(double numero) {
		if (numero < 1) {
			throw new IllegalArgumentException("'numero' deve ser >= a 1");
		}

		double i = 1;
		double soma = 1;

		while (soma < numero) {
			i = i + 2;
			soma = soma + i;
		}

		return soma == numero;
	}

	/**
	 * Função matemática que faz o cálculo da raiz
	 * 
	 * @param {double} numero inteiro que representa o radicando
	 * @param {double} i inteiro que representa o índice
	 * 
	 * @returns {double} Retorna o resultado da raiz
	 */
	public static double raiz(double numero, double i) {
		if (numero <= 0) {
			throw new IllegalArgumentException("'numero' deve ser maior que 0");
		}

		double raizR = 1;

		while (0 <= i) {
			raizR = (raizR + numero / raizR) / 2;
			i = i - 1;

		}

		return raizR;
	}

	/**
	 * Função que verifica se o número é primo
	 * 
	 * @param {int} numero inteiro a ser verificado
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso
	 */
	public static boolean primo(int numero) {
		if (numero <= 1) {
			throw new IllegalArgumentException("'numero' deve ser maior que 1");
		}

		int i = 2;

		while (i < numero) {
			if (numero % i == 0) {
				return false;
			}
			i = i + 1;
		}

		return true;
	}

	/**
	 * Função que calcula o Crivo de Eratostenes
	 * 
	 * @param {int[]} original vetor utilizado na operação
	 * 
	 * @returns {int} Retorna o valor do Crivo de Eratostenes
	 */
	public static int[] crivoEratostenes(final int[] original) {
		// TODO teste se original é null

		// TODO veja
		// https://docs.oracle.com/javase/7/docs/api/java/lang/Object.html#clone()
		// TODO melhor ainda
		// https://docs.oracle.com/javase/7/docs/api/java/lang/System.html#arraycopy%28java.lang.Object,%20int,%20java.lang.Object,%20int,%20int%29
		int[] vetor = original.clone();

		if (vetor.length <= 1) {
			throw new IllegalArgumentException("o vetor deve conter no mínimo 2 dígitos");
		}

		for (int valor : vetor) {
			if (valor != 0) {
				return null;
			}
		}

		int limite = (int) Math.floor(raiz(vetor.length, 100));

		for (int i = 1; i < limite; i++) {
			if (vetor[i] == 0) {
				int multiplo = 2 * i;
				while (multiplo < vetor.length) {
					vetor[multiplo] = 1;
					multiplo = multiplo + i;
				}
			}
		}

		return vetor;
	}

	/**
	 * Função que calcula o maior divisor comum
	 * 
	 * @param {double} numeroA inteiro que representa o dividendo
	 * @param {double} numeroB inteiro que representa o divisor
	 * 
	 * @returns {double} Retorna o maior divisor comum
	 */
	public static double mdc(double numeroA, double numeroB) {
		if (numeroB > numeroA && 0 >= numeroB) {
			throw new IllegalArgumentException("'numeroB' deve ser <= 'numeroA' e numeroB deve ser < 0");
		}

		double resto;

		while (numeroB != 0) {
			resto = numeroA % numeroB;
			numeroA = numeroB;
			numeroB = resto;
		}

		return numeroA;
	}

	/**
	 * Função que calcula o maior divisor comum
	 * 
	 * @param {double} numeroA inteiro que representa o dividendo
	 * @param {double} numeroB inteiro que representa o divisor
	 * 
	 * @returns {double} Retorna o maior divisor comum
	 */
	public static double mdc2(double numeroA, double numeroB) {
		if (numeroB > numeroA && 0 >= numeroB) {
			throw new IllegalArgumentException("'numeroB' deve ser <= 'numeroA' e numeroB deve ser < 0");
		}

		while (numeroA != numeroB) {
			if (numeroA > numeroB) {
				numeroA = numeroA - numeroB;
			} else {
				numeroB = numeroB - numeroA;
			}

		}

		return numeroA;
	}

	/**
	 * Função que avalia um polinômio de acordo com a regra de Horner
	 * 
	 * @param {int}   numero inteiro utilizado no calculo
	 * @param {int[]} vetor inteiro que representa o polinomio
	 * 
	 * @returns {int} Retorna o resultado do polinomio
	 */
	public static int horner(int numero, int[] vetor) {
		if (vetor.length < 1) {
			throw new IllegalArgumentException("O comprimento do vetor deve ser maior ou igual a 1");
		}

		int resultado = vetor[vetor.length - 1];

		for (int i = vetor.length - 1; i >= 0; i--) {
			resultado = resultado * numero + vetor[i];
		}

		return resultado;
	}

	/**
	 * Função que obtém o n-ésimo número de Fibonacci
	 * 
	 * @param {int} numero inteiro que representa a quantidade de iterações do
	 *              cálculo
	 * 
	 * @returns {int} Retorna o número de Fibonnaci na n-ésima posição
	 */
	public static int fibonacci(int numero) {
		if (numero < 0) {
			throw new IllegalArgumentException("O número deve ser maior ou igual a 0");
		}

		int soma = 0;
		int resultado = 1;

		if (numero == 0 || numero == 1) {
			return resultado;
		}

		int i = 2;

		while (i <= numero) {
			int aux = resultado;
			resultado = resultado + soma;
			soma = aux;
			i++;
		}
		return resultado;
	}

	/**
	 * Função que valida um número de CPF de acordo com seus dígitos verificadores
	 * 
	 * @param {int[]} vetor sequência de números que representa um CPF
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso
	 */
	public static boolean digitoCPF(int[] vetor) {
		if (vetor.length != 11) {
			throw new IllegalArgumentException("Insira a quantidade correta de dígitos (11)");
		}

		int testeA = 0;
		int testeB = 0;

		for (int i = 0; i < 9; i++) {
			testeA += ((i + 1) * vetor[i]);
			testeB += ((i + 1) * vetor[i + 1]);
		}

		int digitoA = mod(mod(testeA, 11), 10);
		int digitoB = mod(mod(testeB, 11), 10);
		return (digitoA == vetor[9] && digitoB == vetor[10]);
	}

	/**
	 * Função que valida um número de CPF de acordo com seus dígitos verificadores
	 * 
	 * @param {int[]} vetor sequência de números que representa um CPF
	 * 
	 * @returns {boolean} Retorna verdadeiro ou falso
	 */
	public static boolean digitoCPF2(int[] vetor) {
		if (vetor.length != 11) {
			throw new IllegalArgumentException("Insira a quantidade correta de dígitos (11)");
		}

		int i = 7;
		int testeA = vetor[8];
		int testeB = vetor[8];

		while (0 <= i) {
			testeA = testeA + vetor[i];
			testeB = testeB + testeA;
			i = i - 1;
		}

		int digitoA = mod(mod(testeB, 11), 10);
		int digitoB = mod(mod(testeB - testeA + (9 * vetor[9]), 11), 10);

		return (digitoA == vetor[9]) && (digitoB == vetor[10]);
	}
}
