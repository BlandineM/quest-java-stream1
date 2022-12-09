import java.util.*;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class Shield {

    public static void main(String[] args) {

        List<Hero> heroes = new ArrayList<>();
        heroes.add(new Hero("Black Widow", 34, false));
        heroes.add(new Hero("Captain America", 100, false));
        heroes.add(new Hero("Vision", 3, true));
        heroes.add(new Hero("Iron Man", 48, false));
        heroes.add(new Hero("Scarlet Witch", 29, true));
        heroes.add(new Hero("Thor", 1501, false));
        heroes.add(new Hero("Spider-Man", 18, false));
        heroes.add(new Hero("Hulk", 49, true));
        heroes.add(new Hero("Doctor Strange", 42, false));

        List<Hero> elders = heroes.stream()
                //.filter(hero -> hero.getAge() > 59)
                .filter(new Predicate<Hero>(){
                    @Override
                    public boolean test(Hero hero) {
                        return hero.getAge() > 59;
                    }
                        }
                )
                .collect(toList());


        System.out.println("\nElders:");
        for (Hero elder : elders) {
            System.out.println(elder.getName());
        }

        List<Hero> intolerants = heroes.stream()
                //.filter(Hero::isGlutenIntolerant)
                .filter(new Predicate<Hero>() {
                    @Override
                    public boolean test(Hero hero) {
                        return hero.isGlutenIntolerant();
                    }
                })
                .collect(toList());

        System.out.println("\nGluten intolerants:");
        for (Hero intolerant : intolerants) {
            System.out.println(intolerant.getName());
        }
    }
}
