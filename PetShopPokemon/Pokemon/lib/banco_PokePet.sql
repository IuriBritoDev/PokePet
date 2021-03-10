create database if not exists Pokepet;
use PokePet;
#drop database PokePet;

create table if not exists tb_funcionario(
	idFunc int primary key,
    Nome varchar(30) not null,
    Cargo varchar(30) not null,
    Login varchar(20) unique not null,
    Senha varchar(20) not null
);
#drop table tb_funcionario;

create table if not exists tb_Produto(
	idProduto int primary key auto_increment,
    #idPocket int default(000),
    Nome varchar(30) not null,
    Preco float not null,
    Estoque int,
    Descricao varchar(300)
);
#drop table tb_produto;


create table if not exists tb_Pokemon(
	id int primary key auto_increment,
    Nome varchar(30) not null unique,
    Preco float not null,
    Estoque int,
    Tipo varchar(30) not null,
    Tipo2 varchar(30),
    #Evolucao int,
    #dEvolucao int,
    Habilidade varchar(30),
    Descricao varchar(300)
);

#alter table tb_Produto add constraint foreign key(idPocket) references tb_Pokemon(id);
#alter table tb_pokemon add constraint foreign key(Evolucao) references tb_Pokemon(id);
#alter table tb_pokemon add constraint foreign key(dEvolucao) references tb_Pokemon(id);

insert into tb_pokemon value
(001, "Bulbasour", 10000, 10, "GRASS", "POISON", "OVERGROW" ,"Bulbasaur can be seen napping in bright sunlight. There is a seed on its back. By soaking up the sun's rays, the seed grows progressively larger."),
(002, "Ivysaur", 20000, 10, "GRASS", "POISON", "OVERGROW" ,"There is a bud on this Pokémon's back. To support its weight, Ivysaur's legs and trunk grow thick and strong. If it starts spending more time lying in the sunlight, it's a sign that the bud will bloom into a large flower soon."),
(003, "Venusaur", 50000, 10, "GRASS", "POISON", "OVERGROW", "There is a large flower on Venusaur's back. The flower is said to take on vivid colors if it gets plenty of nutrition and sunlight. The flower's aroma soothes the emotions of people."),
(004, "Charmander", 10000, 10, "FIRE", null, "BLAZE", "The flame that burns at the tip of its tail is an indication of its emotions. The flame wavers when Charmander is enjoying itself. If the Pokémon becomes enraged, the flame burns fiercely."),
(005, "Charmeleon", 20000, 10, "FIRE", null, "BLAZE", "Charmeleon mercilessly destroys its foes using its sharp claws. If it encounters a strong foe, it turns aggressive. In this excited state, the flame at the tip of its tail flares with a bluish white color."),
(006, "Charizard", 50000, 10, "FIRE", "FLYING", "BLAZE", "Charizard flies around the sky in search of powerful opponents. It breathes fire of such great heat that it melts anything. However, it never turns its fiery breath on any opponent weaker than itself."),
(007, "Squirtle", 10000, 10, "WATER", null, "TORRENT", "Squirtle's shell is not merely used for protection. The shell's rounded shape and the grooves on its surface help minimize resistance in water, enabling this Pokémon to swim at high speeds."),
(008, "Wartutle", 20000, 10, "WATER", null, "TORRENT", "Its tail is large and covered with a rich, thick fur. The tail becomes increasingly deeper in color as Wartortle ages. The scratches on its shell are evidence of this Pokémon's toughness as a battler."),
(009, "Blastoise", 50000, 10, "WATER", null, "TORRENT", "Blastoise has water spouts that protrude from its shell. The water spouts are very accurate. They can shoot bullets of water with enough accuracy to strike empty cans from a distance of over 160 feet.");

#update tb_pokemon set Evolucao = 002 where id = 001;
#update tb_pokemon set Evolucao = 003 where id= 002;
#update tb_pokemon set Evolucao = 005 where id= 004;
#update tb_pokemon set Evolucao = 006 where id= 005;
#update tb_pokemon set Evolucao = 008 where id= 007;
#update tb_pokemon set Evolucao = 009 where id= 008;

select * from tb_pokemon;

insert into tb_produto(nome, preco, estoque, descricao) values
("Poké Ball", 200, 50, "A device for catching wild Pokémon. It is thrown like a ball at the target. It is designed as a capsule system."),
("Great Ball", 600, 20, "A good, high-performance Ball that provides a higher Pokémon catch rate than a standard Poké Ball."),
("Ultra Ball", 1200, 30, "An ultra-performance Ball that provides a higher Pokémon catch rate than a Great Ball."),
("Potion", 300, 80, "Restores 20 HP."),
("Super Potion", 700, 30, "Restores 60 HP."),
("Hyper Potion", 1200, 30, "Restores 120 HP."),
("Max Potion", 2500, 25, "Fully restores HP."),
("Full Restore", 3000, 10, "A medicine that fully restores the HP and heals any status problems of a single Pokémon."),
("Revive", 1500, 15, "A medicine that revives a fainted Pokémon. It restores half the Pokémon's maximum HP."),
("Antidote", 100, 30, "A spray-type medicine. It lifts the effect of poison from one Pokémon."),
("Paralyze Heal", 200, 30, "A spray-type medicine. It eliminates paralysis from a single Pokémon."),
("Awakening", 250, 30, "A spray-type medicine. It awakens a Pokémon from the clutches of sleep."),
("Burn Heal", 250, 30, "A spray-type medicine. It heals a single Pokémon that is suffering from a burn."),
("Ice Heal", 250, 30, "	A spray-type medicine. It defrosts a Pokémon that has been frozen solid."),
("Full Heal", 600, 20, "A spray-type medicine. It heals all the status problems of a single Pokémon."),
("Escape Rope", 550, 30, "A long, durable rope. Use it to escape instantly from a cave or a dungeon."),
("Repel", 350, 30, "An item that prevents weak wild Pokémon from appearing for 100 steps after its use."),
("Super Repel", 500, 30, "An item that prevents weak wild Pokémon from appearing for 200 steps after its use."),
("Max Repel", 700, 30, "An item that prevents weak wild Pokémon from appearing for 250 steps after its use.");

select * from tb_produto;

#select * from vw_pokemon where Tipo != "item";

insert into tb_funcionario(idFunc, Nome, Cargo, Login, Senha) value
(1, "Iuri", "Scrum Master", "Iuri", "Iuri"),
(2, "Daniel", "Mestre Das Programação", "Daniel", "Daniel"),
(3, "Andre", "O Fazedor De Telas", "Andre", "Andre"),
(4, "Leonardo", "Treinador Pokemon", "Leonardo", "Leonardo");