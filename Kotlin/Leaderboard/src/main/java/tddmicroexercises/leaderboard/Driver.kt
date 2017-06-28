package tddmicroexercises.leaderboard

open class Driver(val name: String, val country: String) {

    override fun hashCode(): Int {
        return name.hashCode() * 31 + country.hashCode()
    }

    override fun equals(obj: Any?): Boolean {
        if (this === obj) {
            return true
        }
        if (obj == null || obj !is Driver) {
            return false
        }
        val other = obj as Driver?
        return this.name == other!!.name && this.country == other.country
    }
}
