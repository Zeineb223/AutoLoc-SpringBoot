package tn.esprit.autoloc.exception;
public class ResourceNotFoundException extends RuntimeException { public ResourceNotFoundException(String type,Long id) { super(type+" introuvable avec l'identifiant "+id); } }
