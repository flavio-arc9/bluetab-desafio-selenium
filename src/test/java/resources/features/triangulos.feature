@scenario @all
Feature: Identificación de Tipos de Triángulos

    Background: El usuario accede a la aplicación de identificación de triángulos
        Given que el usuario ha abierto la aplicación de identificación de triángulos

    @TC_000
    Scenario: Verificar el ingreso de un usuario 
        When el usuario ingresa el dato ""
        Then debe mostrar un mensaje de error "The name field is blank. Please enter your name in the field at the top of the instructions."

    @TC_001
    Scenario: Verificar un triángulo equilátero
        When el "usuario" ingresa los lados "3", "3" y "3"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "equilateral"

    @TC_002
    Scenario: Verificar un triángulo escaleno
        When el "usuario" ingresa los lados "3", "4" y "5"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "scalene"

    @TC_003
    Scenario: Verificar un triángulo isósceles
        When el "usuario" ingresa los lados "3", "3" y "4"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "isosceles"

    @TC_004
    Scenario: Verificar un triángulo equilátero con lados grandes
        When el "usuario" ingresa los lados "1000000", "1000000" y "1000000"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "equilateral"

    @TC_005
    Scenario: Intentar formar un triángulo inválido
        When el "usuario" ingresa los lados "1", "2" y "5"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "Not a triangle"

    @TC_006
    Scenario: Validar la entrada de un lado negativo
        When el "usuario" ingresa los lados "-1", "3" y "4"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "Not a triangle"

    @TC_007
    Scenario: Validar la entrada de lados nulos
        When el "usuario" ingresa los lados "null", "null" y "null"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "scalene"

    @TC_008
    Scenario: Validar la entrada de lados no numéricos
        When el "usuario" ingresa los lados "'a'", "'b'" y "'c'"
        And el usuario presiona el botón de verificación
        Then debe mostrar el tipo de triángulo como "scalene"

