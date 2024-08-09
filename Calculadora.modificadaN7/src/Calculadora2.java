import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Calculadora2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> resultados = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\nCalculadora de Área, Perímetro y Potencia");
                System.out.println("1. Círculo");
                System.out.println("2. Cuadrado");
                System.out.println("3. Triángulo");
                System.out.println("4. Rectángulo");
                System.out.println("5. Pentágono");
                System.out.println("6. Mostrar resultados");
                System.out.println("7. Salir");
                System.out.print("\nElige una figura: ");
                int figura = scanner.nextInt();

                if (figura == 7) {
                    System.out.println("\nSaliendo del programa...");
                    break;
                }

                if (figura == 6) {
                    mostrarResultados(resultados);
                    continue;
                }

                System.out.println("1. Calcular Área");
                System.out.println("2. Calcular Perímetro");
                System.out.println("3. Calcular Potencia");
                System.out.print("Elige una operación: ");
                int operacion = scanner.nextInt();

                String resultado = "";
                switch (figura) {
                    case 1:
                        System.out.print("Ingresa el radio del círculo: ");
                        double radio = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = calcularAreaCirculo(radio);
                        } else if (operacion == 2) {
                            resultado = calcularPerimetroCirculo(radio);
                        } else if (operacion == 3) {
                            resultado = calcularPotencia("Círculo", radio);
                        }
                        break;
                    case 2:
                        System.out.print("Ingresa el lado del cuadrado: ");
                        double ladoCuadrado = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = calcularAreaCuadrado(ladoCuadrado);
                        } else if (operacion == 2) {
                            resultado = calcularPerimetroCuadrado(ladoCuadrado);
                        } else if (operacion == 3) {
                            resultado = calcularPotencia("Cuadrado", ladoCuadrado);
                        }
                        break;
                    case 3:
                        System.out.print("Ingresa la base del triángulo: ");
                        double base = scanner.nextDouble();
                        System.out.print("Ingresa la altura del triángulo: ");
                        double altura = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = calcularAreaTriangulo(base, altura);
                        } else if (operacion == 2) {
                            System.out.print("Ingresa el lado 1 del triángulo: ");
                            double lado1 = scanner.nextDouble();
                            System.out.print("Ingresa el lado 2 del triángulo: ");
                            double lado2 = scanner.nextDouble();
                            System.out.print("Ingresa el lado 3 del triángulo: ");
                            double lado3 = scanner.nextDouble();
                            resultado = calcularPerimetroTriangulo(lado1, lado2, lado3);
                        } else if (operacion == 3) {
                            resultado = calcularPotencia("Triángulo", base);
                        }
                        break;
                    case 4:
                        System.out.print("Ingresa la longitud del rectángulo: ");
                        double longitud = scanner.nextDouble();
                        System.out.print("Ingresa el ancho del rectángulo: ");
                        double ancho = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = calcularAreaRectangulo(longitud, ancho);
                        } else if (operacion == 2) {
                            resultado = calcularPerimetroRectangulo(longitud, ancho);
                        } else if (operacion == 3) {
                            resultado = calcularPotencia("Rectángulo", longitud);
                        }
                        break;
                    case 5:
                        System.out.print("Ingresa el lado del pentágono: ");
                        double ladoPentagono = scanner.nextDouble();
                        System.out.print("Ingresa el apotema del pentágono: ");
                        double apotema = scanner.nextDouble();
                        if (operacion == 1) {
                            resultado = calcularAreaPentagono(ladoPentagono, apotema);
                        } else if (operacion == 2) {
                            resultado = calcularPerimetroPentagono(ladoPentagono);
                        } else if (operacion == 3) {
                            resultado = calcularPotencia("Pentágono", ladoPentagono);
                        }
                        break;
                    default:
                        System.out.println("Opción inválida. Por favor, elija una opción válida.");
                }

                if (!resultado.isEmpty()) {
                    resultados.add(resultado);
                    System.out.println(resultado);
                }

            } catch (InputMismatchException e) {
                System.out.println("Entrada inválida. Por favor, ingresa un valor numérico.");
                scanner.next(); // Limpiar el buffer del scanner
            }

            System.out.println();
        }

        scanner.close();
    }

    private static void mostrarResultados(List<String> resultados) {
        System.out.println("Resultados almacenados:");
        for (String resultado : resultados) {
            System.out.println(resultado);
        }
    }

    // Métodos para calcular áreas
    private static String calcularAreaCirculo(double radio) {
        double area = Math.PI * Math.pow(radio, 2);
        return "El área del círculo es: " + area;
    }

    private static String calcularAreaCuadrado(double lado) {
        double area = Math.pow(lado, 2);
        return "El área del cuadrado es: " + area;
    }

    private static String calcularAreaTriangulo(double base, double altura) {
        double area = (base * altura) / 2;
        return "El área del triángulo es: " + area;
    }

    private static String calcularAreaRectangulo(double longitud, double ancho) {
        double area = longitud * ancho;
        return "El área del rectángulo es: " + area;
    }

    private static String calcularAreaPentagono(double lado, double apotema) {
        double area = (5 * lado * apotema) / 2;
        return "El área del pentágono es: " + area;
    }

    // Métodos para calcular perímetros
    private static String calcularPerimetroCirculo(double radio) {
        double perimetro = 2 * Math.PI * radio;
        return "El perímetro del círculo es: " + perimetro;
    }

    private static String calcularPerimetroCuadrado(double lado) {
        double perimetro = 4 * lado;
        return "El perímetro del cuadrado es: " + perimetro;
    }

    private static String calcularPerimetroTriangulo(double lado1, double lado2, double lado3) {
        double perimetro = lado1 + lado2 + lado3;
        return "El perímetro del triángulo es: " + perimetro;
    }

    private static String calcularPerimetroRectangulo(double longitud, double ancho) {
        double perimetro = 2 * (longitud + ancho);
        return "El perímetro del rectángulo es: " + perimetro;
    }

    private static String calcularPerimetroPentagono(double lado) {
        double perimetro = 5 * lado;
        return "El perímetro del pentágono es: " + perimetro;
    }

    // Método para calcular potencia (usando recursividad)
    private static String calcularPotencia(String figura, double base) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingresa el exponente para la potencia de " + figura + ": ");
        int exponente = scanner.nextInt();
        double potencia = calcularPotenciaRecursiva(base, exponente);
        return "La potencia de " + base + " elevado a " + exponente + " es: " + potencia;
    }

    private static double calcularPotenciaRecursiva(double base, int exponente) {
        if (exponente == 0) {
            return 1;
        } else if (exponente == 1) {
            return base;
        } else {
            return base * calcularPotenciaRecursiva(base, exponente - 1);
        }
    }
}

