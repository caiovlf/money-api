CREATE TABLE pessoa (
	codigo BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	nome VARCHAR(50) NOT NULL,
    logradouro VARCHAR(50),
	numero VARCHAR(50),     
	complemento VARCHAR(50),
	bairro VARCHAR(50),     
	cep VARCHAR(50),        
	cidade VARCHAR(50),
	estado VARCHAR(50),     
    ativo BOOLEAN          

)ENGINE=InnoDB DEFAULT CHARSET=utf8;


INSERT INTO pessoa (nome,ativo) value('Caio',true);
INSERT INTO pessoa (nome,ativo) value('Larissa',true);
INSERT INTO pessoa (nome,ativo) value('Gabi',true);
