package fr.unice.polytech.kaleate.builder;


import java.util.List;

public interface BuilderChoix<E, R> extends Builder<R> {
    public R newChoix(String nomChoix, int nbChoix, List<E> listeChoix);

    public void nomChoix(String nomChoix);

    public void nbChoix(int nbChoix);

    public void listeChoix(List<E> listeChoix);

    default void addChoix(List<E> liste, E choix)
    {
        liste.add(choix);
    }

    public void addChoix(E choix);

    public List<E> getChoix();

    @Override
    public R getResult();
}