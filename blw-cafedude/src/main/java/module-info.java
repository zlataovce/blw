module dev.xdark.blw.cafedude {
    requires static org.jetbrains.annotations;
    requires transitive dev.xdark.blw;

    requires cafedude.core;
    requires cafedude.tree;
    opens dev.xdark.blw.cafedude;
}
