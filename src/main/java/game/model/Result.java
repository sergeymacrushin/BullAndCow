package game.model;

import javax.persistence.*;

@Entity
@Table(name = "results")
public class Result {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @JoinColumn(name="id_game", nullable=false)
    private int id_game;

    @Column(name = "userint")
    private int userint;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_game() {
        return id_game;
    }

    public void setId_game(int id_game) {
        this.id_game = id_game;
    }

    public int getUserint() {
        return userint;
    }

    public void setUserint(int userint) {
        this.userint = userint;
    }
    public int getBulls(int random)
    {
        int tempUser = this.userint;
        int tempRand = random;
        int bulls=0;
        for(int i=3;i>=0;i--)
        {
            if(tempUser /(int)(Math.pow(10,i))==tempRand /(int)(Math.pow(10,i)))
            {
                bulls++;
            }
            tempUser %= (int)(Math.pow(10,i));
            tempRand %= (int)(Math.pow(10,i));
        }
        return bulls;
    }
        public int getCows(int random)
    {
        int tempUser = this.userint;
        int tempRand = random;
        int cows=0;
        for(int i = 3;i>=0;i--)
        {
            for(int j=3;j>=0;j--)
            {
                if(tempUser /(int)(Math.pow(10,i))==tempRand /(int)(Math.pow(10,j)))
                {
                    cows++;
                }
                tempRand %= (int)(Math.pow(10,j));
            }
            tempUser %= (int)(Math.pow(10,i));
            tempRand = random;
        }
        cows-=this.getBulls(random);
        return cows;
    }
}
