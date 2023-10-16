using System.Text.Json;

var builder = WebApplication.CreateBuilder(args);

builder.Services.AddCors(options =>
{
    options.AddPolicy("no-cors-policy", policy =>{
        policy.AllowAnyHeader().AllowAnyMethod().AllowAnyOrigin();
    });
});
var app = builder.Build();
app.UseCors("no-cors-policy");

string adjectiveFileName = "Adjectives.json";
string adjectiveJsonString = File.ReadAllText(adjectiveFileName);
List<string> adjectives = JsonSerializer.Deserialize<List<string>>(adjectiveJsonString)!;

string peopleFileName = "People.json";
string peopleJsonString = File.ReadAllText(peopleFileName);
List<string> people = JsonSerializer.Deserialize<List<string>>(peopleJsonString)!;

// Until we figure out how to serailize smoji's, this will have to do.
List<string> emojis = new List<string>() {"rocket","fire","pineapple","party","ghost","robot","skull","puzzle"};

app.MapGet("/", () => $"Everything is up and running on {Environment.MachineName}");

app.MapGet("/code", () =>
{
    Random rnd = new Random();
    Code code = new Code()
    {
        Person = people.ElementAt(rnd.Next(0, people.Count)),
        Adjective = adjectives.ElementAt(rnd.Next(0, adjectives.Count)),
        Emoji = emojis.ElementAt(rnd.Next(0, emojis.Count)),
    };
    var jsonCode = System.Text.Json.JsonSerializer.Serialize<Code>(code);
    Console.WriteLine($"{jsonCode}");
    return jsonCode;
}).RequireCors("no-cors-policy");

app.Run();
