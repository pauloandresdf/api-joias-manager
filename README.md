# API "Jóias Manager" - Gestão para Loja de Joias

## Descrição:
Uma API para gerenciar todos os aspectos de uma loja de joias, incluindo estoque de produtos, pedidos personalizados, clientes, vendas e relatórios financeiros. A ideia é criar uma ferramenta que ajude a organizar e automatizar processos, aumentando a eficiência e a rentabilidade do negócio.

## Funcionalidades Principais:

### Cadastro e Autenticação de Usuários:
- Registro e login de usuários (com JWT para autenticação).
- Perfis de acesso (ex: Administrador, Vendedor, Estoquista).

### Gerenciamento de Estoque:
- Cadastrar joias com detalhes como nome, tipo (anel, colar, pulseira, etc.), material (ouro, prata, etc.), pedras preciosas (diamante, rubi, etc.), quantidade e preço.
- Avisar quando um item está com estoque baixo.
- Registrar entradas e saídas de produtos.

### Gerenciamento de Pedidos Personalizados:
- Cadastrar pedidos personalizados de clientes com detalhes como tipo de joia, material, pedras preciosas, tamanho, prazo de entrega e observações.
- Associar pedidos a joias específicas e calcular custos e preços de venda.
- Acompanhar status do pedido (ex: "Em produção", "Pronto para entrega", "Concluído").

### Gerenciamento de Clientes:
- Cadastrar clientes com informações como nome, contato, endereço e histórico de compras.
- Oferecer descontos ou promoções para clientes fiéis.
- Enviar notificações sobre novos produtos ou promoções.

### Gestão de Vendas:
- Registrar vendas de joias com detalhes como produto, cliente, valor e forma de pagamento.
- Calcular comissões de vendedores.
- Gerar recibos e notas fiscais.

### Gestão Financeira:
- Calcular custos totais de produção e vendas.
- Registrar preços de venda e lucro por venda.
- Gerar relatórios de custos, receitas e lucros (diários, semanais, mensais).

### Notificações e Lembretes:
- Enviar lembretes para repor estoque ou preparar pedidos.
- Notificações de pedidos urgentes ou atrasados.

### Relatórios e Insights:
- Gerar relatórios de desempenho (ex: "Joias mais vendidas", "Clientes mais fiéis").
- Insights sobre eficiência de vendas e rentabilidade.

<!-- 
 ## Tecnologias Utilizadas:
- **Spring Boot 3**: Para criar a API RESTful.
- **Java 17**: Versão LTS do Java.
- **Spring Security**: Para autenticação JWT.
- **Spring Data JPA**: Para persistência de dados.
- **Banco de Dados**:Mysql
- **Railway**: Para deploy na nuvem.
- **Docker**: Para containerizar a aplicação.
- **Swagger/OpenAPI**: Para documentação da API.
- **Twilio ou Firebase**: Para notificações.
- **GitHub Actions**: Para CI/CD.
--> 

## Exemplo de Endpoints:

### Usuários:
- `POST /api/usuarios/registro`: Registrar um novo usuário.
- `POST /api/usuarios/login`: Fazer login e receber um token JWT.
- `PUT /api/usuarios/{id}/perfil`: Atualizar perfil do usuário.

### Estoque:
- `POST /api/estoque`: Cadastrar uma nova joia.
- `GET /api/estoque`: Listar todas as joias.
- `PUT /api/estoque/{id}/atualizar`: Atualizar quantidade de uma joia.
- `GET /api/estoque/alertas`: Listar joias com estoque baixo.

### Pedidos Personalizados:
- `POST /api/pedidos`: Cadastrar um novo pedido personalizado.
- `GET /api/pedidos`: Listar todos os pedidos.
- `PUT /api/pedidos/{id}/status`: Atualizar status de um pedido.
- `GET /api/pedidos/{id}/custo`: Calcular custo e lucro de um pedido.

### Clientes:
- `POST /api/clientes`: Cadastrar um novo cliente.
- `GET /api/clientes`: Listar todos os clientes.
- `PUT /api/clientes/{id}/desconto`: Oferecer desconto a um cliente.

### Vendas:
- `POST /api/vendas`: Registrar uma nova venda.
- `GET /api/vendas`: Listar todas as vendas.
- `GET /api/vendas/{id}/recibo`: Gerar recibo de uma venda.

### Financeiro:
- `GET /api/financeiro/relatorios`: Gerar relatórios de custos, receitas e lucros.
- `GET /api/financeiro/insights`: Receber insights sobre desempenho financeiro.

### Notificações:
- `POST /api/notificacoes/lembrete`: Enviar um lembrete personalizado.
