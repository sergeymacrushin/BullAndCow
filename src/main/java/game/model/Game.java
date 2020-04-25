package game.model;
import javax.persistence.*;


@Entity( name = "Game")
@Table (name = "games")
public class Game {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "random")
    private int random;


    @JoinColumn(name="id_user", nullable=false)
    private int id_user;

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }



    public Game() {
        boolean i=true;
        while(i) {
            random = (int)(Math.random() * (9000)) + 1000;
            if(Game.isGoodRandom(random))
            {
                i=false;
            }
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }

    static boolean isGoodRandom(int random)
    {
        int randomMirror = random;
        for(int i = 3; i>=0; i--)
        {
            randomMirror %= (int)(Math.pow(10,i));
            for(int j=i-1;j>=0;j--)
            {
                if(random /(int)(Math.pow(10,i))== randomMirror /(int)(Math.pow(10,j))) {
                    return false;
                }
                randomMirror %= (int)(Math.pow(10,j));
            }
            random %= (int) (Math.pow(10,i));
            randomMirror = random;
        }
        return true;
    }
}
