// Tables

create table Lancamento (
	oid serial primary key not null,
    dt_inicial TIMESTAMP not null,
    dt_final TIMESTAMP not null,
    vl_total numeric(8,2),
    observacao varchar(1000)
);

create table Item (
	oid serial primary key not null,
    descricao varchar(255),
    valor numeric(8,2)
);

create table LancamentoItem (
    id serial primary key not null,
	oid_lancamento integer references Lancamento(oid),
    oid_item integer references Item(oid)
);

// 10
select * from lancamento as l where (l.vl_total / (select count(li.id) from lancamentoitem as li where oid_lancamento = l.oid)) >= 100;
// 11
select * from lancamento as l where substring(l.observacao from 1 for 1) = 'A' and vl_total > 50 order by l.vl_total DESC limit 10;
// 12
update lancamento set observacao = observacao || '- Possuem mais que 10 itens' where oid in (select l2.oid from lancamento as l2 where (select count(id) from lancamentoitem as li where li.oid_lancamento = l2.oid) > 10);