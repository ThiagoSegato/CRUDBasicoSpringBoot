insert into banda(nome, genero) values('Soundgarden', 'GRUNGE');
insert into banda(nome, genero) values('Audioslave', 'GRUNGE');
insert into banda(nome, genero) values('Nirvana', 'GRUNGE');
insert into banda(nome, genero) values('Foo Fighters', 'GRUNGE');
--
insert into musico(nome, apelido) values('Christopher John Boyle', 'Chris Cornell');
insert into musico(nome, apelido) values('David Eric Grohl', 'Dave Grohl');
insert into musico(nome, apelido) values('Kurt Donald Cobain', 'Kurt Cobain');
insert into musico(nome, apelido) values('Krist Anthony Novoselic ', 'Krist Novoselic');
insert into musico(nome, apelido) values('Georg Albert Ruthenberg', 'Pat Smear');
insert into musico(nome, apelido) values('Nathan ‍Gregor ‍Mendel', 'Nate Mendel');
insert into musico(nome, apelido) values('Christopher Aubrey Shiflett', 'Chris Shiflett');
insert into musico(nome, apelido) values('Rami Jaffee', 'Rami Jaffee');
--
insert into banda_integrantes(banda_id, musico_id, instrumento) values(1, 1, 'VOCAL');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(2, 1, 'VOCAL');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(3, 2, 'BATERIA');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(3, 3, 'GUITARRA');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(3, 4, 'BAIXO');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(4, 2, 'VOCAL');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(4, 5, 'GUITARRA');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(4, 6, 'BAIXO');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(4, 7, 'GUITARRA');
insert into banda_integrantes(banda_id, musico_id, instrumento) values(4, 8, 'TECLADO');

