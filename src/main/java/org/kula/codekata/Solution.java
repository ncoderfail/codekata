package org.kula.codekata;

import org.apache.commons.cli.CommandLine;

public interface Solution<T> {
    T run(CommandLine cmd);
}
