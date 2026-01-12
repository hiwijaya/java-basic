package com.hiwijaya.javabasic.sealed;

/**
 * Sealed classes.
 * Introduced in Java 17. Sealing allows classes and interfaces to define their permitted subtypes.
 * In other words, a class or interface can define which classes can implement or extend it.
 * It’s a useful feature for domain modeling.
 * A permitted subclass MUST define a modifier:
 * - {@code final} Cannot be subclassed by any other class.
 * - {@code sealed} Can only be subclassed by a specific, explicitly listed set of classes defined in a permits clause.
 * - {@code non-sealed} Can be subclassed by any class without restriction.
 *
 */
public sealed interface Payment permits Card, Cash {

    void pay();

}
