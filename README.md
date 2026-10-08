# Bestiário de Pandora 🌿

App Android que cataloga a fauna de Pandora, o planeta do filme *Avatar*. A ideia
visual é a de um **diário de campo de um naturalista**: uma floresta
bioluminescente à noite, com cores escuras e destaques em verde-água.

**Aluno:** (seu nome) — **RA:** (seu RA)

---

## O que o app faz

O app tem **duas telas**:

1. **Catálogo** — lista rolável com 10 criaturas. Cada card mostra foto, nome,
   nome na'vi e habitat.
2. **Detalhe** — ao tocar num card, abre uma tela com a foto grande, nome, nome
   na'vi, habitat, tamanho e descrição da criatura. O botão **"Voltar ao
   catálogo"** retorna para a lista.

```
Catálogo  ──(toque no card)──►  Detalhe  ──(botão Voltar)──►  Catálogo
```

---

## Tecnologias utilizadas

| Tecnologia | Para quê |
|---|---|
| **Kotlin** | Linguagem do app |
| **Android Views + layouts XML** | Montar as telas (sem Jetpack Compose) |
| **ViewBinding** | Ligar o XML ao Kotlin sem `findViewById` |
| **RecyclerView** | Lista rolável do catálogo |
| **Material Components** | Tema base do app (`Material3`) |
| **Dados mockados** | Lista fixa no código, sem API e sem banco de dados |

- SDK mínimo: **24** (Android 7.0)

---

## Estrutura do projeto

```
app/src/main/
├── AndroidManifest.xml          Registra as duas Activities
├── java/com/example/pandoraanimallife/
│   ├── Criatura.kt              Modelo de dados (data class)
│   ├── CriaturaRepo.kt          Lista mockada com as 10 criaturas
│   ├── CriaturaAdapter.kt       Adapter que monta cada card da lista
│   ├── MainActivity.kt          Tela 1: catálogo
│   └── DetalheActivity.kt       Tela 2: detalhe da criatura
└── res/
    ├── drawable/
    │   ├── bg_card.xml          Fundo arredondado dos cards
    │   └── foto_*.jpg           Fotos das criaturas
    ├── layout/
    │   ├── activity_main.xml    Layout do catálogo
    │   ├── activity_detalhe.xml Layout do detalhe
    │   └── item_criatura.xml    Layout de um card da lista
    └── values/
        ├── colors.xml           Paleta de cores
        └── strings.xml          Textos da interface
```

---

## Como cada requisito foi atendido

### 1. Duas telas em XML com Views e ViewGroups

As telas foram feitas em XML usando:

- **Views:** `TextView`, `ImageView`, `Space`, `Button`
- **ViewGroups:** `LinearLayout`, `ScrollView`, `RecyclerView`

O catálogo usa um `RecyclerView` porque ele reaproveita os cards que saem da tela,
deixando a lista leve. O detalhe usa um `ScrollView` para que o conteúdo role em
telas pequenas.

### 2. Navegação por Intent explícita com passagem de dados

Ao tocar num card, a `MainActivity` abre a `DetalheActivity` enviando apenas o
**id** da criatura:

```kotlin
// MainActivity.kt
val intent = Intent(this, DetalheActivity::class.java)
intent.putExtra("CRIATURA_ID", idCriatura)
startActivity(intent)
```

A `DetalheActivity` recebe o id e busca a criatura completa na lista:

```kotlin
// DetalheActivity.kt
val criaturaId = intent.getIntExtra("CRIATURA_ID", -1)
val criatura = CriaturaRepo.buscarPorId(criaturaId)

// se o id não existir, fecha a tela em vez de quebrar o app
if (criatura == null) {
    finish()
    return
}
```

### 3. ViewBinding e interação com o usuário

O ViewBinding foi ativado no `app/build.gradle.kts`:

```kotlin
buildFeatures {
    viewBinding = true
}
```

Com isso, o Android gera uma classe para cada layout (`ActivityMainBinding`,
`ActivityDetalheBinding`, `ItemCriaturaBinding`), e as Views são acessadas
direto por ela, por exemplo `binding.tvNome.text = criatura.nome`.

Interações tratadas:

- **Clique no card** do catálogo → abre a tela de detalhe.
- **Botão "Voltar ao catálogo"** → fecha o detalhe e volta para a lista:

```kotlin
binding.btnVoltar.setOnClickListener {
    finish()
}
```

### 4. Modelo imutável (data class) e valores opcionais

```kotlin
data class Criatura(
    val id: Int,
    val nome: String,
    val nomeNavi: String?,   // opcional: nem toda criatura tem nome na'vi
    val habitat: String,
    val tamanho: String?,    // opcional: nem toda criatura tem tamanho catalogado
    val descricao: String,
    val foto: Int
)
```

Todos os campos são `val`, então um objeto `Criatura` não muda depois de criado.
Os campos com `?` podem ser nulos, e foram tratados de **duas formas diferentes**
para mostrar as duas abordagens:

**a) Esconder a View** — quando não há nome na'vi, o campo some da tela:

```kotlin
if (criatura.nomeNavi != null) {
    binding.nomeNavi.text = criatura.nomeNavi
    binding.nomeNavi.visibility = View.VISIBLE
} else {
    binding.nomeNavi.visibility = View.GONE
}
```

No adapter, o `else` é obrigatório: o `RecyclerView` reaproveita os cards, e sem
ele um card escondido poderia continuar escondido (ou mostrar o nome de outra
criatura).

**b) Texto alternativo** — quando não há tamanho, aparece um texto padrão com o
operador Elvis (`?:`):

```kotlin
binding.tamanho.text = criatura.tamanho ?: "Tamanho não catalogado"
```

Para testar esses casos no app:

| Criatura | Sem nome na'vi | Sem tamanho |
|---|---|---|
| Banshee | | ✔ |
| Prolemuris | ✔ | ✔ |
| Tulkun | ✔ | |

### 5. Dados simulados (mocks)

Os dados ficam no `CriaturaRepo.kt`, um `object` com a lista fixa das 10
criaturas e uma função para buscar pelo id:

```kotlin
object CriaturaRepo {
    val lista = listOf(
        Criatura(id = 1, nome = "Banshee", nomeNavi = "Ikran", ...),
        // ... mais 9 criaturas
    )

    fun buscarPorId(id: Int): Criatura? = lista.find { it.id == id }
}
```

Não há API nem banco de dados.

---

## Itens opcionais

- [x] **Usar apenas ViewBinding** — não existe nenhum `findViewById` no projeto.
- [ ] Componentes XML reutilizáveis com eventos que atualizem a interface.
- [ ] Interface funcional em `Fragment`.

---

## Como rodar

1. Abrir a pasta do projeto no **Android Studio**.
2. Esperar o Gradle sincronizar.
3. Rodar num emulador ou celular com **Android 7.0 (API 24) ou superior**.

---

