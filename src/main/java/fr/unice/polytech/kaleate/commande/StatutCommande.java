package fr.unice.polytech.kaleate.commande;

public enum StatutCommande {
    EN_CREATION,
    // VALIDEE : la commande est validée par un des restaurants de la commande
    VALIDEE,
    PAYEE,
    EN_PREPARATION,
    ANNULEE,
    PRETE,
    EN_LIVRAISON,
    A_RECUPERER,
    LIVREE,

}
