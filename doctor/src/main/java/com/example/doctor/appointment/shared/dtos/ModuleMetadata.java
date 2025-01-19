package com.example.doctor.appointment.shared.dtos;

import org.springframework.modulith.ApplicationModule;
import org.springframework.modulith.NamedInterface;
import org.springframework.modulith.PackageInfo;

@PackageInfo
@NamedInterface("appointment.shared.*")
@ApplicationModule(type = ApplicationModule.Type.OPEN)
public class ModuleMetadata {
}