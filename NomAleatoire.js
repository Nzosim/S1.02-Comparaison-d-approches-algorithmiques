const lettre = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"

for(let i = 0; i < 5 ; i++){
    let nom = ""
    const tailleNom = Math.floor(Math.random() * (10 - 1 + 1)) + 1
    for(let i = 0; tailleNom ; i++){
        const alea = Math.floor(Math.random() * (26 - 0 + 1)) + 0
        nom += lettre[alea]
    } 
    console.log(nom)
} 