CREATE TABLE pautas (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  titulo VARCHAR NOT NULL,
  descricao VARCHAR NOT NULL,
  PRIMARY KEY(id)
);

CREATE TABLE sessoes (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  pautas_id INTEGER UNSIGNED NOT NULL,
  status_sessao ENUM NOT NULL,
  data_sessao DATE NOT NULL,
  PRIMARY KEY(id),
  INDEX sessoes_FKIndex1(pautas_id)
);

CREATE TABLE votacoes (
  id INTEGER UNSIGNED NOT NULL AUTO_INCREMENT,
  sessoes_id INTEGER UNSIGNED NOT NULL,
  cpf VARCHAR NOT NULL,
  voto ENUM NOT NULL,
  data_voto DATE NOT NULL,
  PRIMARY KEY(id),
  INDEX votacoes_FKIndex1(sessoes_id),
  CONSTRAINT UK_Votacoes UNIQUE (sessoes_id, cpf)
);


