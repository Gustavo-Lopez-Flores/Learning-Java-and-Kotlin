# Shard Bank

Bem-vindo ao repositório do trabalho prático da disciplina de Computação Distribuída, o objetivo é implementar:

## Client 
> solicita um função OpClient() com os parâmetros de:
- i. Data operação
- ii. ContaCliente 
- iii. Tipo (C para Credito ou D para Debito)
- iv. Valor operação

<br>

## Transaction Coordinator 
> solicita ao Servidor de banco de dados: Shard A, a função Credito() com os parâmetros:
- i. Data operação
- ii. ContaCliente
- iii. Valor operação

<br>

## Transaction Coordinator
> solicita ao Servidor de banco de dados: Shard B, a função Debito() com os parâmetros:
- i. Data operação
- ii. ContaCliente
- iii. Valor operação

### Representação:
<img src="https://github.com/Gustavo-Lopez-Flores/Shard-Bank/blob/main/assets/img.png" alt="model" width="800" height="500">
