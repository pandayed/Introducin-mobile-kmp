package `in`.introduc.mobile.data
import Post
import getCurrentTimeMillis

object PostDataSource {

    fun getFakePosts(): List<Post> {
        return listOf(
            Post(
                id = "1",
                authorName = "Alice",
                authorHandle = "@alice",
                content = "Hello, world! This is my first post.",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "2",
                authorName = "Bob",
                authorHandle = "@bob",
                content = "Just had a great coffee. #morningvibes",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "3",
                authorName = "Charlie",
                authorHandle = "@charlie",
                content = "Exploring the mountains today. #adventure",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "4",
                authorName = "Diana",
                authorHandle = "@diana",
                content = "Reading a great book on philosophy. #deepthoughts",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "5",
                authorName = "Eve",
                authorHandle = "@eve",
                content = "Just baked some cookies. #homemade",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "6",
                authorName = "Frank",
                authorHandle = "@frank",
                content = "Watching the sunset by the beach. #peaceful",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "7",
                authorName = "Grace",
                authorHandle = "@grace",
                content = "Learning Kotlin is so much fun! #coding",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "8",
                authorName = "Hank",
                authorHandle = "@hank",
                content = "Just finished a 5k run. Feeling great! #fitness",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "9",
                authorName = "Ivy",
                authorHandle = "@ivy",
                content = "Trying out a new recipe today. #cooking",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "10",
                authorName = "Jack",
                authorHandle = "@jack",
                content = "Listening to some classic rock. #music",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "11",
                authorName = "Karen",
                authorHandle = "@karen",
                content = "Planting some flowers in my garden. #nature",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "12",
                authorName = "Leo",
                authorHandle = "@leo",
                content = "Sketching a new art piece. #creative",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "13",
                authorName = "Mia",
                authorHandle = "@mia",
                content = "Enjoying a cup of tea on a rainy day. #cozy",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "14",
                authorName = "Nina",
                authorHandle = "@nina",
                content = "Just adopted a puppy! #cute",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "15",
                authorName = "Oscar",
                authorHandle = "@oscar",
                content = "Building a new PC. #tech",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "16",
                authorName = "Paul",
                authorHandle = "@paul",
                content = "Watching a documentary on space. #science",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "17",
                authorName = "Quinn",
                authorHandle = "@quinn",
                content = "Trying out yoga for the first time. #wellness",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "18",
                authorName = "Rachel",
                authorHandle = "@rachel",
                content = "Exploring a new city. #travel",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "19",
                authorName = "Steve",
                authorHandle = "@steve",
                content = "Playing chess with friends. #strategy",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            ),
            Post(
                id = "20",
                authorName = "Tina",
                authorHandle = "@tina",
                content = "Learning to play the guitar. #hobby",
                timestamp = getCurrentTimeMillis(),
                profileImageUrl = null
            )
        )
    }
}