# 📱Calculadora de Gorjeta

Este é um aplicativo Android Nativo desenvolvido em Kotlin que auxilia na divisão de contas em restaurantes de forma simples e intuitiva. O usuário pode escolher se deseja ou não adicionar gorjeta, com a porcentagem definida dinamicamente. O app calcula automaticamente os valores e exibe um resumo detalhado em outra tela. Além disso, o usuário pode recalcular ou limpar os campos para refazer as contas.

## :camera_flash: Screenshots
<!-- You can add more screenshots here if you like -->
<img src="https://github.com/user-attachments/assets/de405d89-14a7-43e5-b00d-ccdc68d0dabd" width=200/> <img src="https://github.com/user-attachments/assets/06fc0fe3-544e-41a9-be8c-f51b98b14249" width=200/> <img src="https://github.com/user-attachments/assets/e9dc9328-6402-4820-bd56-7ca9a3134bcc" width=200/> <img src="https://github.com/user-attachments/assets/0aefb116-a846-431b-8c65-45c2e6c8d461" width=200/>


## Tecnologias
- Activity
- Intent
- Bundle
- Parcelable
- screenOrientation
- ViewBinding
- Snackbar
- 
## Layouts e Componentes de UI
- Viewgroups:
  - ConstraintLayout
  - LinearLayout
- Views:
  - TextView
  - TextInputLayout/ TextInputEditText
  - Radiogroup/ Radiobutton
  - Button
 
## Métodos e Recursos:
  - ViewBinding
  - Intent/ Bundle
  - Parcelable
  - Snackbar
  - Estruturas condicionais "if/else if"
  - isEmpty/ setError
  - Uso do operador seguro "?.let"
  - Uso de expressões lambda

## Lógica e Processamento
  - Validação de campos de entrada;
  - Uso do Snackbar para feedback ao usuário;
  - Passagem de objetos entre Activitys usando Parcelable;
  - Uso do onResume() para limpeza de tela;
  - Uso do operador "?.let" para verificar valores nulos antes de acessá-los;
  - Uso do "with(binding)" para otimizar atribuições de "Views";
  - Modularização do código para validação de campos e realização de cálculos;
  - Conversão de valores para 2 casas decimais;
  - Esconder o teclado ao clicar nos botões (InputMethodManager.hideSoftInputFromWindow());
  - Exibir ou ocultar campos dinamicamente (View.VISIBLE, View.GONE);
  - Resetar o formulário após click no botão (clearCheck(), text?.clear());
 
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

 
  
