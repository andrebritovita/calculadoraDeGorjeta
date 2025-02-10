## Calculadora de Gorjeta

Este é um aplicativo Android Nativo desenvolvido em Kotlin que permite ao usuário calcular a divisão da conta em um restaurante, com ou sem gorjeta, de forma dinâmica. O usuário pode selecionar se deseja adicionar uma gorjeta e definir a porcentagem. O resultado detalhado é exibido em uma segunda tela, e há a opção de recalcular ou limpar os campos.

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="https://github.com/user-attachments/assets/1725b9ec-e1b8-4176-8ac0-2ac975f83d6e" width=200/> <img src="https://github.com/user-attachments/assets/90bd0061-c7a2-49fd-9180-2d1511d9280b" width=200/> <img src="https://github.com/user-attachments/assets/32ca435d-b01d-46e3-bfd5-5adbc79585c8" width=200/> <img src="https://github.com/user-attachments/assets/b9a3fe04-8c67-4b41-9d03-fd3bf8d3f274" width=200/>

## Tecnologias
- Activity
- Intent
- Bundle
- screenOrientation
- ViewBinding
- Viewgroups:
  - ConstraintLayout
  - LinearLayout
- Views:
  - TextView
  - TextInputLayout/ TextInputEditText
  - Radiogroup/ Radiobutton
  - Button
 
  ## Métodos e Recursos
- Métodos Utilizados:
  - ViewBinding
  - Intent/ Bundle
  - Snackbar
  - Estruturas condicionais "if/else if"
  - isEmpty/ setError

  ## Lógica e Processamento
  - Passagem de dados entre Activitys usando Intent.extras
  - Modularização de métodos para verificação de campos e realização de cálculos
  - Conversão de Strings para números (toFloat(), toInt())
  - Esconder o teclado ao clicar nos botões (InputMethodManager.hideSoftInputFromWindow())
  - Exibir ou ocultar campos dinamicamente (View.VISIBLE, View.GONE)
  - Resetar o formulário após click no botão (clearCheck(), text?.clear())
 
## License
```
The MIT License (MIT)

Copyright (c) 2025 André Brito Vita

Permission is hereby granted, free of charge, to any person obtaining a copy of
this software and associated documentation files (the "Software"), to deal in
the Software without restriction, including without limitation the rights to
use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
the Software, and to permit persons to whom the Software is furnished to do so,
subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
```

 
  
