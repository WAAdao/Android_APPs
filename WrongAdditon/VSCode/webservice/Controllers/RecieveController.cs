using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Logging;
using MySql.Data.MySqlClient;

namespace webservice.Controllers
{
    [ApiController]
    [Route("[controller]{JsonString}")]
    public class Recieve : ControllerBase
    {
       public string ConnectionString{get; set;}
        [HttpPost]
        public  String run([FromRoute]String JsonString)
        {           
            MySql.Data.MySqlClient.MySqlConnection con = new MySql.Data.MySqlClient.MySqlConnection("Server=localhost;Port=3306;Database=test;Uid=user;pwd=root");
            con.Open();
            MySqlCommand com = new MySqlCommand("INSERT INTO test.teste2 (valor1) VALUES ('"+ JsonString +"');");
            com.Connection =  con;
            com.ExecuteNonQuery();  
            return JsonString; 
        }
    }
}