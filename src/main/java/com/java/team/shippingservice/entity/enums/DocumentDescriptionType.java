package com.java.team.shippingservice.entity.enums;

import lombok.Getter;

@Getter
public enum DocumentDescriptionType {
    ANNUAL_REPORTS("Annual reports"),
    BILL_LANDING("Bill of lading"),
    BLUEPRINT("Blueprints"),
    BOOKLET("Booklets, brochures - non-advertising"),
    BUSINESS_CARD("Business cards"),
    CATALOG("Catalogs"),
    CERTIFICATE("Certificates"),
    CHART("Charts, graphs"),
    FORM("Completed Forms"),
    CONTACT("Contract"),
    CREDIT_NOTE("Credit note"),
    DEED("Deeds"),
    DIARY("Diaries"),
    DISKETTE("Diskettes"),
    DOCUMENT("Documents - general business"),
    EDUCATIONAL_MATERIAL("Educational material - printed"),
    EXAMINATION_PAPER("Examination papers"),
    IDENTITY_DOCUMENT("Identity document"),
    INVOICE("Invoices - not blank"),
    LETTER("Letter, correspondence"),
    MANUAL("Manuals - technical"),
    MANUSCRIPT("Manuscripts"),
    MEDIA_STORAGE("Media storage device"),
    MICROFICHE("Microfiche, microfilm"),
    PASSPORT("Passports"),
    PHOTOGRAPH("Photographs"),
    PHOTOGRAPH_REPORT("Photographs - as part of business reports"),
    PLAN("Plans, drawings - for architectural, industrial, engineering purposes"),
    PRICE_LIST("Price lists"),
    PRINTED_MATTER("Printed matter"),
    SHIP_MANIFEST("Ship manifest - computer generated"),
    SHIPPING_SCHEDULE("Shipping schedules"),
    SLIDE("Slides"),
    TRANSPARENCY("Transparencies"),
    UNACTIVATED_CREDIT_CARD("Unactivated Credit/Debit/ATM Card"),
    VISA_APPLICATION("Visa applications"),


    ;
    private String descriptionEn;

    private DocumentDescriptionType(String descriptionEn) {
        this.descriptionEn = descriptionEn;
    }
}
