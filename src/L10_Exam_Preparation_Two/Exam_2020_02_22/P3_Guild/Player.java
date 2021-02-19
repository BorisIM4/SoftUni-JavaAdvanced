package L10_Exam_Preparation_Two.Exam_2020_02_22.P3_Guild;

public class Player {
    private String name;
    private String clazz;
    private String rank;
    private String description;

    public Player(String name, String clazz){
        this.name = name;
        this.clazz = clazz;
        this.rank = "Trial";
        this.description = "n/a";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClazz() {
        return clazz;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(String.format("Player %s: %s" ,this.name , this.clazz));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Rank: %s",this.rank));
        stringBuilder.append(System.lineSeparator());
        stringBuilder.append(String.format("Description: %s" ,this.description));

        return stringBuilder.toString().trim();
    }
}
