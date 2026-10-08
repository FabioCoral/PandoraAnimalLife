package com.example.pandoraanimallife

object CriaturaRepo{
    val lista = listOf<Criatura>(
        Criatura(
            id = 1,
            nome = "Banshee",
            nomeNavi = "Ikran",
            habitat = "Penhascos flutuantes das Montanhas Aleluia",
            tamanho = null,
            descricao = "O Ikran é o banshee montanhês que os Na'vi laçam ainda jovens para formar o Tsaheylu, o vínculo de uma vida inteira entre cavaleiro e criatura.",
            foto = R.drawable.foto_banshee
        ),
        Criatura(
            id = 2,
            nome = "Thanator",
            nomeNavi = "Palulukan",
            habitat = "Florestas densas de Pandora",
            tamanho = "Cerca de 6 metros de comprimento",
            descricao = "Predador de seis patas e couraça óssea, o Palulukan é um dos caçadores mais temidos das florestas — ataca sem hesitar até presas do tamanho de um Na'vi.",
            foto = R.drawable.foto_thanator
        ),
        Criatura(
            id = 3,
            nome = "Viperwolf",
            nomeNavi = "Nantang",
            habitat = "Florestas e campos abertos",
            tamanho = "Porte semelhante a um lobo grande",
            descricao = "Caça em matilha e se comunica por padrões de bioluminescência ao longo do corpo, coordenando ataques contra presas maiores.",
            foto = R.drawable.foto_viperwolf
        ),
        Criatura(
            id = 4,
            nome = "Direhorse",
            nomeNavi = "Pa'li",
            habitat = "Planícies abertas de Pandora",
            tamanho = "Maior que um cavalo terrestre",
            descricao = "Montaria de seis patas usada pelos Na'vi para se deslocar pelas planícies, também vinculada ao cavaleiro pelo Tsaheylu.",
            foto = R.drawable.foto_direhorse
        ),
        Criatura(
            id = 5,
            nome = "Prolemuris",
            nomeNavi = null, // sem nome na'vi catalogado de propósito
            habitat = "Copas das árvores da floresta",
            tamanho = null, // também sem tamanho, pra demonstrar os dois campos opcionais juntos
            descricao = "Primata arborícola de quatro braços, ágil o bastante para saltar entre galhos altos em perseguições rápidas.",
            foto = R.drawable.foto_prolemuris
        ),
        Criatura(
            id = 6,
            nome ="Tulkun",
            nomeNavi = null, // sem nome na'vi catalogado de propósito
            habitat = "Oceanos de Pandora" ,
            tamanho = "Até 27 metros de comprimento",
            descricao = "Mamífero marinho altamente inteligente, sagrado para o povo Metkayina, com uma cultura e linguagem próprias.",
            foto = R.drawable.foto_tulkun
        ),
        Criatura(
            id = 7,
            nome = "Great Leonopteryx",
            nomeNavi = "Toruk",
            habitat = "Céus de Pandora e Montanhas Aleluia",
            tamanho = "Envergadura de mais de 25 metros",
            descricao = "O superpredador aéreo de Pandora, distinguível por sua coloração vibrante em vermelho, amarelo e preto. Domá-lo é um feito lendário que concede ao cavaleiro o título de Toruk Makto.",
            foto = R.drawable.foto_toruk
        ),
        Criatura(
            id = 8,
            nome = "Hexapede",
            nomeNavi = "Yerik",
            habitat = "Florestas de toda Pandora",
            tamanho = "Cerca de 1,5 metros de comprimento",
            descricao = "Um dos herbívoros terrestres mais comuns e dóceis do planeta. É a principal fonte de carne para os Na'vi e o primeiro animal caçado durante os ritos de passagem.",
            foto = R.drawable.foto_yerik
        ),
        Criatura(
            id = 9,
            nome = "Skimwing",
            nomeNavi = "Tsurak",
            habitat = "Oceanos tropicais e áreas costeiras",
            tamanho = "Cerca de 14 metros de comprimento",
            descricao = "Poderosa criatura marinha anfíbia utilizada como montaria de caça e guerra pelos clãs dos recifes, capaz de planar longas distâncias sobre a superfície da água.",
            foto = R.drawable.foto_tsurak
        ),
        Criatura(
            id = 10,
            nome = "Ilu",
            nomeNavi = "Ilu",
            habitat = "Recifes rasos e águas costeiras",
            tamanho = "Cerca de 7 metros de comprimento",
            descricao = "Criatura marinha dócil e veloz, equivalente aquático do Direhorse. É a montaria padrão para o dia a dia das tribos oceânicas, como os Metkayina.",
            foto = R.drawable.foto_ilu
        )

    )

    fun buscarPorId(id: Int): Criatura? = lista.find{ it.id == id}
}