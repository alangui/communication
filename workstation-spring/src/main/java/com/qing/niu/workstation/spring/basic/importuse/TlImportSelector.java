package com.qing.niu.workstation.spring.basic.importuse;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * <p>
 * </p>
 *
 * @Author Gui Jin Kang
 * @Date 2020/12/28
 * @ProjectName communication
 * @Version 1.0.0
 */
public class TlImportSelector implements ImportSelector {

    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{"com.qing.niu.workstation.spring.model.WithholdReqDTO"};
    }
}
