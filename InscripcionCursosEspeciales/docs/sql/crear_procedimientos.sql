CREATE OR REPLACE procedure ANALISIS.SF_REVERSAR_CARGOS_MATRICULA
(
    P_EMPLID VARCHAR2
    ,P_STRM VARCHAR2
    ,P_ACCOUNT_NBR VARCHAR2
    ,P_BUSINESS_UNIT VARCHAR2
    ,P_INSTITUTION VARCHAR2
    ,P_OPRID VARCHAR2
) IS
    ERROR_REMBOLSO_MANUAL EXCEPTION;
BEGIN   
    NULL;

    COMMIT;
 
EXCEPTION
    WHEN ERROR_REMBOLSO_MANUAL THEN
        raise_application_error(-20001, 'El pago no se puede reversar por este medio; procesar manualmente. emplid:'||P_EMPLID||' strm:'||P_STRM||' account_nbr:'||P_ACCOUNT_NBR||' '||sqlcode || ': ' || sqlerrm);
    WHEN OTHERS THEN  
        ROllBACK;
        raise_application_error(-20000, 'Error con emplid:'||P_EMPLID||' strm:'||P_STRM||' account_nbr:'||P_ACCOUNT_NBR||' '||sqlcode || ': ' || sqlerrm);        
END;
/

CREATE OR REPLACE procedure ANALISIS.SF_ACREDITAR_ABONOS
(
    P_EMPLID VARCHAR2
    ,P_STRM VARCHAR2
    ,P_ACCOUNT_NBR VARCHAR2
    ,P_BUSINESS_UNIT VARCHAR2
    ,P_INSTITUTION VARCHAR2
    ,P_OPRID VARCHAR2
) IS
    ERROR_REMBOLSO_MANUAL EXCEPTION;
BEGIN   
    NULL;

    COMMIT;
 
EXCEPTION
    WHEN ERROR_REMBOLSO_MANUAL THEN
        raise_application_error(-20001, 'El pago no se puede reversar por este medio; procesar manualmente. emplid:'||P_EMPLID||' strm:'||P_STRM||' account_nbr:'||P_ACCOUNT_NBR||' '||sqlcode || ': ' || sqlerrm);
    WHEN OTHERS THEN  
        ROllBACK;
        raise_application_error(-20000, 'Error con emplid:'||P_EMPLID||' strm:'||P_STRM||' account_nbr:'||P_ACCOUNT_NBR||' '||sqlcode || ': ' || sqlerrm);        
END;


/