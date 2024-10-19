module dev.xdark.blw.asm {
    requires static org.jetbrains.annotations;
    requires transitive dev.xdark.blw;

    requires transitive org.objectweb.asm;
    opens dev.xdark.blw.asm;
}
