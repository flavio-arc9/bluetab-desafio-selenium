@scenario-outline @all
Feature: Identificación de Tipos de Triángulos

    Background: El usuario accede a la aplicación de identificación de triángulos
        Given que el usuario ha abierto la aplicación de identificación de triángulos

    Scenario Outline: Verificar los tipos de triángulos <tipo>
        When el "<usuario>" ingresa los lados "<lado1>", "<lado2>" y "<lado3>"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "<tipo>"
        Examples:
            | usuario | lado1   | lado2   | lado3   | tipo        |
            | Joe     | 3       | 3       | 3       | equilateral |
            | Tito    | 3       | 4       | 5       | scalene     |
            | Kael    | 3       | 3       | 4       | isosceles   |
            | Juan    | 1000000 | 1000000 | 1000000 | equilateral |

    Scenario Outline: Validar entradas inválidas <mensaje_error>
        When el "<usuario>" ingresa los lados "<lado1>", "<lado2>" y "<lado3>"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "<tipo>"

        Examples:
            | usuario   | lado1 | lado2 | lado3 | mensaje_error                   | tipo           |
            | Jackeline | 1     | 2     | 5     | no se puede formar un triángulo | Not a triangle |
            | Carla     | -1    | 3     | 4     | de un lado negativo             | Not a triangle |
            | Matias    | null  | null  | null  | de lados nulos                  | scalene        |
            | Daniela   | 'a'   | 'b'   | 'c'   | de lados no numéricos           | scalene        |
