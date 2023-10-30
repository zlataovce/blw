package dev.xdark.blw.classfile;

import dev.xdark.blw.classfile.generic.GenericRecordComponent;

public sealed interface RecordComponent extends Named, Typed, Signed, Annotated permits GenericRecordComponent {}
